package com.asorokin.controller;

import com.asorokin.service.InitService;
import com.asorokin.service.OrderService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChooseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InitService.init();
        if (request.getParameter("chkBox") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/mistake.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                HttpSession session = httpRequest.getSession();

                //session.setAttribute("userName", request.getParameter("userName"));
                session.getAttribute("userName");

                OrderService.choose(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ChooseServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
