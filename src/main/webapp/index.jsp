<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 11/4/21
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<%--<%@include file="viewProducts.jsp" %>--%>
<html>
<title>Welcome</title>
<body class="container">
<div class="card-panel">
    <div class="section center">
        <h1>Iconic Beauty</h1>
        <div class="divider"></div>
        <div class="row center">
            <p></p>

            <c:if test="${empty userName}">
                <a href="logIn">
                    <button type="button" class="btn waves-effect waves-blue darken-2">Log in</button>
                </a>
            </c:if>
        </div>
<%--        <div class="row center">--%>
<%--                <h3>Welcome ${userName}</h3>--%>
<%--                <form action="viewProducts" class="" method="post">--%>
<%--                    <input type="hidden" class="" id="userName" name="userName" value="${userName}">--%>
<%--                    <button type="submit" name="submit" class="btn waves-effect waves-blue darken-2">View Products--%>
<%--                    </button>--%>
<%--                </form>--%>
<%--        </div>--%>
    </div>
</div>
</body>
</html>