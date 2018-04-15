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

public class ServletController extends HttpServlet {

    @Override
    public void init() {
        Good.createListOfGoods();
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
            default:
                index(request, response);
                break;
        }

    }

    private void index(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void choose(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getParameter("chkBox") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("mistake.jsp");
            dispatcher.forward(request, response);
        } else {
            List<Good> listGood = Good.getListOfGoods();
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession();
            session.setAttribute("listGood", listGood);

            RequestDispatcher dispatcher = request.getRequestDispatcher("goodList.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
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
                Good tmp = new Good();
                tmp = iter.next();
                if (selectedGood.equals(tmp.getGoodTitle())) {
                    goods.add(tmp);
                }
            }
        }
        session.setAttribute("goods", goods);

        RequestDispatcher dispatcher = request.getRequestDispatcher("goodList.jsp");
        dispatcher.forward(request, response);
    }

    private void order(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderPage.jsp");
        dispatcher.forward(request, response);
    }
}
