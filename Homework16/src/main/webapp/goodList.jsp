<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.asorokin.Good"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Online Shop</title>
    </head>
    <body>
    <center>
        <h1>Hello, <%=session.getAttribute("userName")%>!</h1>
        <h2>
            <c:if test="${goods == null}">
                Make your order
            </c:if>
        </h2>
        <p>
            <c:if test="${goods != null}">
                <c:if test="${goods != null}">
                    <c:forEach var="good" items="${goods}" varStatus="counter">
                    <p>
                        <c:out value="${counter.count}" />)
                        <c:out value="${good.goodTitle}" /> 
                        (<c:out value="${good.goodPrice}" /> $)
                    </p>
                </c:forEach>
            </c:if>
        </c:if>
    </p>
</center>

<div align="center">
    <form action="order" method="post" > 
        <input type="hidden" name="userName" value="<%=request.getParameter("userName")%>">
        <select name="good">
            <c:forEach var="good" items="${listGood}">
                <option value="<c:out value="${good.goodTitle}" />">
                    <c:out value="${good.goodTitle}" /> 
                    (<c:out value="${good.goodPrice}" /> $)
                </option>
            </c:forEach>
        </select>
        <br>
        <input type=submit value="Add item" formaction="add">
        <input type=submit value="Submit">              
    </form>   
</div>   
</body>
</html>