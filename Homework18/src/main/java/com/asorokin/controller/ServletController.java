package com.asorokin.controller;

import com.asorokin.dao.GoodDAO;
import com.asorokin.dao.OrderDAO;
import com.asorokin.dao.UserDAO;
import com.asorokin.model.Good;
import com.asorokin.model.Order;
import com.asorokin.model.User;
import com.asorokin.model.OrderGood;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletController extends HttpServlet {

    private GoodDAO goodDAO;
    private OrderDAO orderDAO;
    private UserDAO userDAO;
    private static int userID = 1;
    private static int orderID = 1;
    private static float total_price = 0;

    public void init() {

        String jdbcURL = "jdbc:h2:mem:shop;DB_CLOSE_DELAY=-1";
        goodDAO = new GoodDAO(jdbcURL);
        orderDAO = new OrderDAO(jdbcURL);
        userDAO = new UserDAO(jdbcURL);

        try {
            goodDAO.createTable();
            orderDAO.createTable();
            userDAO.createTable();
        } catch (SQLException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        session.setAttribute("userName", httpRequest.getParameter("userName"));

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/add":
                    add(request, response);
                    break;
                case "/order":
                    order(request, response);
                    break;
                case "/choose":
                    choose(request, response);
                    break;
                case "/listGood":
                    listGood(request, response);
                    break;
                default:
                    index(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listGood(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Good> listGood = goodDAO.listAllGoods();
        request.setAttribute("listGood", listGood);

        RequestDispatcher dispatcher = request.getRequestDispatcher("GoodList.jsp");
        dispatcher.forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void choose(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        if (request.getParameter("chkBox") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("mistake.jsp");
            dispatcher.forward(request, response);
        } else {
            orderDAO.insertOrder(new Order(userID, 0));
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession();

            String login = (String) session.getAttribute("userName");
            userDAO.insertUser(new User(userID, login, ""));
            List<Good> listGoodDB = goodDAO.listAllGoods();

            session.setAttribute("listGoodDB", listGoodDB);

            RequestDispatcher dispatcher = request.getRequestDispatcher("goodList.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        List<Good> listGoodDB = goodDAO.listAllGoods();
        String selectedGood = request.getParameter("good");

        Order order;
        if (selectedGood != null) {
            Iterator<Good> iter = listGoodDB.iterator();
            while (iter.hasNext()) {
                Good tmp = iter.next();
                if (selectedGood.equals(tmp.getTitle())) {
                    orderDAO.insertOrderGood(new OrderGood(orderID, tmp.getID()));
                    total_price += tmp.getPrice();
                }
            }
            orderDAO.updateOrder(new Order(orderID, userID, total_price));
        }
        List<Good> listAllSelectedGood = orderDAO.listAllSelectedGood();
        session.setAttribute("listAllSelectedGood", listAllSelectedGood);
        session.setAttribute("total_price", total_price);

        RequestDispatcher dispatcher = request.getRequestDispatcher("goodList.jsp");
        dispatcher.forward(request, response);
    }

    private void order(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        List<Good> listAllSelectedGood = orderDAO.listAllSelectedGood();

        session.setAttribute("listAllSelectedGood", listAllSelectedGood);

        RequestDispatcher dispatcher = request.getRequestDispatcher("orderPage.jsp");
        dispatcher.forward(request, response);
    }
}
