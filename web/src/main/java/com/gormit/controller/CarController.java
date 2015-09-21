package com.gormit.controller;

import com.gormit.constance.Constance;
import com.gormit.pojos.Car;
import com.gormit.pojos.Client;
import com.gormit.service.CarService;
import com.gormit.service.ClientService;
import com.mysql.jdbc.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Gormit on 18.09.2015.
 * Car Controller
 * Send to UI a Client and his List of Cars
 * And get from UI Car ID and Client ID
 * Also get Car form to save or update
 */

@WebServlet("/cars")
public class CarController  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CarController() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CarService carService = new CarService();
        int clientId = 0;

        if (!StringUtils.isNullOrEmpty(request.getParameter("clientId"))) {
            clientId = Integer.parseInt(request.getParameter("clientId"));
        }

        Client client = new ClientService().getClientById(clientId);
        List<Car> carsList = carService.getCarListByClient(client);

        request.setAttribute("client", client);
        request.setAttribute("carsList", carsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constance.WEB_PATH_CARS_PAGE);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        Car car = new Car();
        CarService carService = new CarService();
        ClientService clientService = new ClientService();

        switch (action.toLowerCase()) { //only in Java7 you can put String in switch
            case "save":
                if (!StringUtils.isNullOrEmpty(request.getParameter("carId"))) {
                    car.setId(Integer.parseInt(request.getParameter("carId")));
                }
                car.setMake(request.getParameter("make"));
                car.setModel(request.getParameter("model"));
                car.setYear(request.getParameter("year"));
                car.setVin(request.getParameter("vin"));
                car.setClient(clientService.getClientById(Integer.parseInt(request.getParameter("clientId"))));
                carService.saveOrUpdate(car);
                doGet(request, response);
                break;
            case "del":
                carService.dellCar(carService.getCarById(Integer.parseInt(request.getParameter("carId"))));
                doGet(request, response);
                break;
            case "edit":
                car = carService.getCarById(Integer.parseInt(request.getParameter("carId")));
                request.setAttribute("car", car);
                doGet(request, response);
                break;
        }
    }
}
