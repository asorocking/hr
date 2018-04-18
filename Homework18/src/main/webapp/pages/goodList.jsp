<%@page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Online Shop</title>
    </head>
    <body>
    <center>
        <h1>Hello, <c:out value="${userName}"/>!</h1>
        <h2>
            <c:if test="${listAllSelectedGood == null}">
                Make your order
            </c:if>
        </h2>
        <p>
            <c:if test="${listAllSelectedGood != null}">
                <c:forEach var="good" items="${listAllSelectedGood}" varStatus="сounter">
                <p>
                    <c:out value="${сounter.count}" />)
                    <c:out value="${good.title}" /> 
                    (<c:out value="${good.price}" /> $)
                </p>
                </c:forEach>
            </c:if>
        </p>

    </center>
<div align="center">
    <form action="order" method="post" > 
        <select name="good">
            <c:forEach var="good" items="${listGoodDB}" varStatus="сounter">
                <option value="<c:out value="${good.title}" />">
                    <c:out value="${сounter.count}" />
                    <c:out value="${good.title}" /> 
                    (<c:out value="${good.price}" /> $)
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