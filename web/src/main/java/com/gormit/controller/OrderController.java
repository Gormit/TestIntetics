package com.gormit.controller;

import com.gormit.constance.Constance;
import com.gormit.pojos.Car;
import com.gormit.pojos.Order;
import com.gormit.service.CarService;
import com.gormit.service.ClientService;
import com.gormit.service.OrderService;
import com.mysql.jdbc.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Gormit on 19.09.2015.
 * Order Controller
 * Send to UI a Car and it List of Orders
 * And get from UI Car ID and Order ID
 * Also get Order form to save or update
 */
@WebServlet("/orders")
public class OrderController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(OrderController.class);
    private static final long serialVersionUID = 1L;

    public OrderController() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderService orderService = new OrderService();
        int carId = 0;

        if (null != request.getParameter("carId")) {
            carId = Integer.parseInt(request.getParameter("carId"));
        }

        Car car = new CarService().getCarById(carId);
        List<Order> orderList = orderService.getOrderListByCar(new CarService().getCarById(carId));

        request.setAttribute("car", car);
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constance.WEB_PATH_ORDERS_PAGE);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        Order order = new Order();
        OrderService orderService = new OrderService();
        CarService carService = new CarService();

        switch (action.toLowerCase()) { //only in Java7 you can put String in switch
            case "save":
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

                if (!StringUtils.isNullOrEmpty(request.getParameter("orderId"))) {
                    order.setId(Integer.parseInt(request.getParameter("orderId")));
                }
                try {
                    order.setDate(formatter.parse(request.getParameter("date")));
                } catch (ParseException e) {
                    logger.error("ParseException to order.setDate " + e);
                }
                order.setPrice(Double.parseDouble(request.getParameter("price").replace(',','.')));
                order.setStatus(request.getParameter("status"));
                order.setCar(carService.getCarById(Integer.parseInt(request.getParameter("carId"))));
                orderService.saveOrUpdate(order);
                doGet(request, response);
                break;
            case "del":
                orderService.dellOrder(orderService.getOrderById(Integer.parseInt(request.getParameter("orderId"))));
                doGet(request, response);
                break;
            case "edit":
                order = orderService.getOrderById(Integer.parseInt(request.getParameter("orderId")));
                request.setAttribute("order", order);
                doGet(request, response);
                break;
        }
    }
}
