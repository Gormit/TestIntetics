package com.gormit.controller;


import com.gormit.constance.Constance;
import com.gormit.pojos.Client;
import com.gormit.service.ClientService;
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
 * Created by Gormit on 17.09.2015.
 * Client Controller with pagination
 * Perhaps it is no good idea to send request every time in DB,
 * all pagination and sorting operation can do in UI,
 * but I don't have skills for that, YET.
 */
@WebServlet("/clients")
public class ClientController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ClientController.class);
    private static final long serialVersionUID = 1L;

    public ClientController() {
        super();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int countRows = 3; //How many rows we well see on page
        ClientService clientService = new ClientService();
        int lastPage;
        if (clientService.getCount() % countRows == 0) {
            lastPage = clientService.getCount() / countRows;
        } else {
            lastPage = clientService.getCount() / countRows + 1;
        }

        if (null != request.getParameter("page")) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        List<Client> clientList = clientService.getPageList(page, countRows);

        request.setAttribute("clientList", clientList);
        request.setAttribute("lastPage", lastPage);
        request.setAttribute("currentPage", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constance.WEB_PATH_LIST_OF_CLIENTS_PAGE);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        ClientService clientService = new ClientService();
        Client client = new Client();


        switch (action.toLowerCase()) { //only in Java7 you can put String in switch
            case "add":
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

                client.setName(request.getParameter("name"));
                client.setSurname(request.getParameter("surname"));
                try {
                    client.setBirthday(formatter.parse(request.getParameter("birthday")));
                } catch (ParseException e) {
                    logger.error("ParseException to client.setBirthday " + e);
                }
                client.setAddress(request.getParameter("address"));
                client.setPhone(request.getParameter("phone"));
                client.setMail(request.getParameter("mail"));
                clientService.addClient(client);

                doGet(request, response);
                break;

            case "search":
                client = clientService.getClientByNameAndSurname(request.getParameter("name"), request.getParameter("surname"));
                request.setAttribute("client", client);
                RequestDispatcher dispatcher = request.getRequestDispatcher(Constance.WEB_PATH_SEARCH_PAGE);
                dispatcher.forward(request, response);
                break;

        }
    }
}
