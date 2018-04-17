package com.asorokin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddServlet extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        List<Good> goods = new ArrayList<Good>();

        if (session.getAttribute("goods") != null) {
            goods = (List<Good>) session.getAttribute("goods");
        }
        List<Good> goodsList = Good.getListOfGoods();
        String selectedGood = request.getParameter("good");

        if (selectedGood != null) {
            Iterator<Good> iter = goodsList.iterator();
            while (iter.hasNext()) {
                Good tmp = iter.next();
                if (selectedGood.equals(tmp.getGoodTitle())) {
                    goods.add(tmp);
                }
            }
        }
        session.setAttribute("goods", goods);

        RequestDispatcher dispatcher = request.getRequestDispatcher("goodList.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    
}
