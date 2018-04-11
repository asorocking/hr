package com.asorokin;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Second extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        List<Good> goods = ListOfGoods.getListOfGoods();

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<center>");
        pw.println("<B>Hello, " + userName + "!");

        pw.println("Make your order");

        pw.println("<form action=\"third\" method=\"post\" > \n"
                + "      <input type=\"hidden\" name=\"userName\" value=\"" 
                               + userName + "\">\n"
                + "      <select name=\"goods\" multiple=\"multiple\">");

        Iterator<Good> iter = goods.iterator();
        while (iter.hasNext()) {
            Good iterGood = iter.next();
            pw.println("<option value=\"" + iterGood.getGoodTitle() + "\">" 
                    + iterGood.getGoodTitle() + " " 
                    + iterGood.getGoodPrice() + "$</option>\n");
        }

        pw.println("     </select>\n"
                + "      <br>\n"
                + "    <input type=submit value=\"Submit\">\n"
                + " </form> ");

        pw.println("</center>");

        pw.close();
    }
}
