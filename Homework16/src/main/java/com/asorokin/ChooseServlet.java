package com.asorokin;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChooseServlet extends HttpServlet {

    @Override
    public void init() {
        Good.createListOfGoods();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        session.setAttribute("userName", httpRequest.getParameter("userName"));
        
        if (request.getParameter("chkBox") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("mistake.jsp");
            dispatcher.forward(request, response);
        } else {
            List<Good> listGood = Good.getListOfGoods();
            session.setAttribute("listGood", listGood);

            RequestDispatcher dispatcher = request.getRequestDispatcher("goodList.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
}
