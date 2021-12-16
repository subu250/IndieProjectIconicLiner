<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/15/21
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp" %>
<%@include file="contentType.jsp" %>
<html>
<title>Item</title>
<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#itemTable').DataTable();
    });
</script>
<body class="container">
<div class="card-panel">
    <div class="section center">
        <h1>${item.name}</h1>
        <div class="divider"></div>
        <h2>Items</h2>
        <form action="item.jsp" class="" method="post">
            <table id="itemTable">
                <thead>
                <th>Name</th>
                <th>Description</th>
                <th>Product</th>
                </thead>
                <tbody>
                <c:forEach var="item" items="${itemSet}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>${item.product}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <input type="hidden" class="" id="productIDUpdate" name="productID" value="${item.id}">
            <button type="submit" value="Refresh" name="submit" class="btn-small waves-effect waves-blue">Refresh
            </button>
        </form>
    </div>
    <div class="row center">
        <p></p>

        <form action="viewProducts" class="row" method="post">
            <input type="hidden" class="" id="userName" name="userName" value="${userName}">
            <button type="submit" name="submit" class="btn waves-effect waves-blue">View Products</button>
        </form>
    </div>
</div>
</body>
</html>