<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.asorokin.Good"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%  HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpSession httpSession = httpRequest.getSession();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Third</title>
    </head>
    <body>
    <center>
        <h3><b>Dear, <%=session.getAttribute("userName")%>, your oder:</b></h3>
            <p>
            <c:if test="${goods != null}">
                <%
                    List<Good> goods = (List<Good>) session.getAttribute("goods");
                    Iterator<Good> iter = goods.iterator();
                    int i = 1;
                    float total = 0;

                    while (iter.hasNext()) {
                        Good iterGood = new Good();
                        iterGood = iter.next();%>
                        <p><%=i%>) <%=iterGood.getGoodTitle()%> 
                           <%=iterGood.getGoodPrice()%>$
                        </p>
                    <%
                         i++;
                         total += iterGood.getGoodPrice();
                    }
                    %>
            </p>
            <p><b>Total: <%=total%>$ </b></p>
        </c:if>
        </center>
</body>
</html>
