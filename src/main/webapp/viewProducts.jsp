<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/9/21
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp" %>
<%@include file="contentType.jsp" %>
<html>
<title>Awesome Products</title>
<body class="container">
<div class="card-panel">
    <div class="section center">
        <h1>Awesome Products</h1>
        <table class="table" id="productsTable">
            <thead>
            <th>Products</th>
            <th></th>
            <th></th>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <form action="productInfo" class="" method="post">
                    <tr>
                        <td>${product.name}</td>
                        <td><input type="hidden" class="" id="productID" name="productID" value="${product.id}"></td>
                        <td>
                            <button type="submit" name="submit" class="btn-small waves-effect waves-blue">View</button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div class="row center">
        <a href="add">
            <button type="button" class="btn waves-effect waves-blue">Product</button>
        </a>
    </div>
</div>
</body>
</html>