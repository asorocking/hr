<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shop</title>
    </head>
    <body>
    <center>
        <h3><b>Dear, <%=session.getAttribute("userName")%>, your oder:</b></h3>
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
        <p><b>Total: <%=session.getAttribute("total_price")%>$ </b></p>
</center>

</body>
</html>