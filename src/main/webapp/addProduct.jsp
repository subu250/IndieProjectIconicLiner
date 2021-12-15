<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/15/21
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="contentType.jsp" %>
<html>
<%@include file="head.jsp" %>
<body class="container" onload="">
<div class="card-panel">
    <h1>Add Products</h1>
    <form action="addProduct" class="" method="post">
        <div class="input-field">
            <input type="hidden" class="" id="userId" name="userId" value="${userId}">
            <input type="text" class="validate" required="" aria-required="true" id="addProduct" name="addProduct" aria-describedby="addProduct" placeholder="Product">
        </div>
        <button type="submit" name="submit" value="addProduct" class="btn waves-effect waves-blue">Add Product</button>
    </form>
</div>
</body>
</html>