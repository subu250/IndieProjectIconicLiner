<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/9/21
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="contentType.jsp" />
<html>
<jsp:include page="head.jsp" />

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#trailsTable').DataTable();
    } );
</script>

<body role="document">
<jsp:include page="navbar.jsp" />

<div class="container-fluid"  role="main">
    <h2>Trails: </h2>
    <table id="trailsTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Trail</th>
        <th>Description</th>
        <th>Length</th>
        <th>Type</th>
        <th>Difficulty</th>
        <th>Map</th>
        <th>Website</th>
        </thead>
        <tbody>
        <c:forEach var="trail" items="${trails}">
            <tr>
                <td>${trail.name}</td>
                <td>${trail.description}</td>
                <td>${trail.length} ${trail.lengthUnits}</td>
                <td>${trail.type.name}</td>
                <td>${trail.difficulty.name}</td>
                <td>${trail.trailMap}</td>
                <td>${trail.website}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
<jsp:include page="contentEnd.jsp" />
<jsp:include page="footer.jsp" />
</html>






  </body>
</html>
