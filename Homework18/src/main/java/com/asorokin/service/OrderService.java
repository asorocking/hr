package com.asorokin.service;

import com.asorokin.model.Good;
import com.asorokin.model.Order;
import com.asorokin.model.OrderGood;
import com.asorokin.model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderService {

    public static void choose(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        InitService.orderDAO.insertOrder(new Order(User.userID, 0));

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        String login = (String) session.getAttribute("userName");
        InitService.userDAO.insertUser(new User(User.userID, login, ""));

        List<Good> listGoodDB = InitService.goodDAO.listAllGoods();
        session.setAttribute("listGoodDB", listGoodDB);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/goodList.jsp");
        dispatcher.forward(request, response);

    }

    public static void add(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        List<Good> listGoodDB = InitService.goodDAO.listAllGoods();
        String selectedGood = request.getParameter("good");

        Order order;
        if (selectedGood != null) {
            Iterator<Good> iter = listGoodDB.iterator();
            while (iter.hasNext()) {
                Good tmp = iter.next();
                if (selectedGood.equals(tmp.getTitle())) {
                    InitService.orderDAO.insertOrderGood(new OrderGood(InitService.orderID, tmp.getID()));
                    InitService.total_price += tmp.getPrice();
                }
            }
            InitService.orderDAO.updateOrder(new Order(InitService.orderID, User.userID, InitService.total_price));
        }
        List<Good> listAllSelectedGood = InitService.orderDAO.listAllSelectedGood();

        session.setAttribute("listAllSelectedGood", listAllSelectedGood);
        session.setAttribute("total_price", InitService.total_price);

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/goodList.jsp");
        dispatcher.forward(request, response);
    }

    public static void order(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        List<Good> listAllSelectedGood = InitService.orderDAO.listAllSelectedGood();

        session.setAttribute("listAllSelectedGood", listAllSelectedGood);

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/orderPage.jsp");
        dispatcher.forward(request, response);
    }

}
