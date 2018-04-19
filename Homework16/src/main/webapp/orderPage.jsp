<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.asorokin.Good"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <c:if test="${goods != null}">
                    <c:forEach var="good" items="${goods}" varStatus="counter">
                    <p>
                        <c:out value="${counter.count}" />)
                        <c:out value="${good.goodTitle}" /> 
                        (<c:out value="${good.goodPrice}" /> $)
                    </p>
                     </c:forEach>
                </c:if>    
            <p><b>Total: <c:out value="${total}"/>$ </b></p>
        </c:if>
        </center>
</body>
</html>
