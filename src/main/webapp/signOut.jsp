<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/12/21
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<html>
<body>
<c:choose>
    <c:when test="${empty userName}">
        <a href = "logOut">Welcome back/a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
    </c:otherwise>
</c:choose>
</body>
</html>