
package com.asorokin;

import java.io.*;

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
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        pw.println("<center>");
        pw.println("<B>Dear , " + userName + ", your oder:");
        pw.println("<br>");
        pw.println("<br>");
        
        Double total = 0.0;
        String[] selectedGoods = request.getParameterValues("goods");
        if (selectedGoods != null) {
            int i = 0;
            for (String item : selectedGoods) {
                String keyValue[] = item.split("-");
                pw.print((i+1) + ") " + keyValue[0] + " ");
                pw.println(keyValue[1] + "$");
                total += Double.valueOf(keyValue[1]);
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
