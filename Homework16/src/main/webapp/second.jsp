<%@page import="com.asorokin.ListOfGoods"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.asorokin.Good"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"     "http://www.w3.org/TR/html4/loose.dtd">
<%  HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpSession httpSession = httpRequest.getSession();

    if (request.getParameter("chkBox") != null) {
        httpSession.setAttribute("authorized", "true");
        httpSession.setAttribute("userName", request.getParameter("userName"));
    }

    if (httpSession.getAttribute("authorized") != "true") {
        response.sendRedirect("mistake.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Second</title>
    </head>
    <body>
        <center>
            <h3><b>Hello, <%=httpSession.getAttribute("userName")%>!</b></h3>

            <%
                List<Good> goods = new ArrayList<Good>();
                
                if (session.getAttribute("goods") != null) {
                    goods = (List<Good>) session.getAttribute("goods");
                }
                List<Good> goodsList = ListOfGoods.getListOfGoods();
                String selectedGood = request.getParameter("good");

                if (selectedGood != null) {
                    Iterator<Good> iter = goodsList.iterator();
                    while (iter.hasNext()){
                        Good tmp = new Good(); 
                        tmp = iter.next();
                        if (selectedGood.equals(tmp.getGoodTitle())){
                            goods.add(tmp);
                        }
                    }
                    %>
            <p>You have already chosen:</p>
            <%
                }
                session.setAttribute("goods", goods);

                Iterator<Good> iter = goods.iterator();
                int i = 1;

                while (iter.hasNext()) {
                    Good iterGood = new Good();
                    iterGood = iter.next();%>
                    <p><%=i%>) <%=iterGood.getGoodTitle()%> 
                        <%=iterGood.getGoodPrice()%>$</p>
            <%
                    i++;
                }
            %>

            <h3>Make your order</h3>
            <form action="third.jsp" method="post" > 
                <input type="hidden" name="userName" value="<%=request.getParameter("userName")%>">
                <select name="good">
                    <%
                    Iterator<Good> iterList = goodsList.iterator();
                    while (iterList.hasNext()) {
                    Good iterGood = iterList.next();%>
                    <option value="<%=iterGood.getGoodTitle()%>">
                        <%=iterGood.getGoodTitle()%> 
                        <%=iterGood.getGoodPrice()%>$</option>
                    <%
                        }
                    %>
                </select>
                <br>
                <input type=submit value="Add item" formaction="second.jsp">
                <input type=submit value="Submit">              
            </form>
        </center>
    </body>
</html>
