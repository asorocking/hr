package com.asorokin;

import java.io.*;
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
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<center>");
        pw.println("<B>Hello, " + userName + "!");

        pw.println("Make your order");
        
        pw.println("<form action=\"third\" method=\"post\" > \n"
                + "            <input type=\"hidden\" name=\"userName\" value=\"" + userName + "\">\n"
                + "            <select name=\"goods\" multiple=\"multiple\">\n"
                + "                <option value=\"Mobile Phone-10.0\">Mobile Phone 10.0$</option>\n"
                + "                <option value=\"Book-5.5\">Book 5.5$</option>\n"
                + "                <option value=\"Pencil-0.3\">Pencil 0.3$</option>\n"
                + "            </select>\n"
                + "            <br>\n"
                + "            <input type=submit value=\"Submit\">\n"
                + "        </form> ");

        pw.println("</center>");
        
        pw.close();
    }
}
