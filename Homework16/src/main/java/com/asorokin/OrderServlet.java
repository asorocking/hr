package com.asorokin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        List<Good> goods = new ArrayList<Good>();
        float total = 0;
        if (session.getAttribute("goods") != null) {
            goods = (List<Good>) session.getAttribute("goods");
        }
        
        Iterator<Good> iter = goods.iterator();
        while (iter.hasNext()) {
            Good tmp = iter.next();
            total += tmp.getGoodPrice();
        }

        session.setAttribute("total", total);

        RequestDispatcher dispatcher = request.getRequestDispatcher("orderPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
