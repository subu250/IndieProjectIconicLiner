<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/9/21
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#trailsTable').DataTable();
    } );
</script>

<body role="document">
<jsp:include page="viewProducts.jsp" />

<div class="container-fluid"  role="main">
    <h2>Products: </h2>
    <table id="products" class="display" cellspacing="0" width="100%">
        <thead>
\        <th>Brand</th>
        <th>Type</th>
        <th>User Name</th>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.user_name}</td>
                <td>${product.brand}</td>
                <td>${product.type}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
<jsp:include page="footer.jsp" />
</html>

  </body>
</html>
