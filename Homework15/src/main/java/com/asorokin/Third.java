package com.asorokin;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Third extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        List<Good> goods = ListOfGoods.getListOfGoods();

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<center>");
        pw.println("<B>Dear, " + userName + ", your oder:");
        pw.println("<br>");
        pw.println("<br>");

        Double total = 0.0;
        String[] selectedGoods = request.getParameterValues("goods");

        if (selectedGoods != null) {
            int i = 1;
            for (String item : selectedGoods) {
                Iterator<Good> iter = goods.iterator();
                while (iter.hasNext()) {
                    Good iterGood = iter.next();
                    if (item.equals(iterGood.getGoodTitle())) {
                        pw.print(i + ") " + iterGood.getGoodTitle() + " " 
                                + +iterGood.getGoodPrice() + "$");
                        total += iterGood.getGoodPrice();
                    }
                }
                i++;
                pw.println("<br>");
            }
        }

        pw.println("<br>");
        pw.println("Total: $ " + total);
        pw.println("</center>");

        pw.close();
    }
}
