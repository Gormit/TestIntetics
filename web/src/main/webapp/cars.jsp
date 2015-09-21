<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 18.09.2015
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="includes.jsp"/>
</head>
<body>

<script>
    $(function(){
        $("[rel='tooltip']").tooltip();
    });
</script>

<div class="container">

    <jsp:include page="header.jsp"/>

    <div class="row" id="content">

        <jsp:include page="menu.jsp"/>

        <div class="span9">

            <jsp:include page="carForm.jsp"/>

            <legend>All Cars Client ${requestScope.client.name}</legend>

            <table class="table table-striped table-hover table-bordered">
                <thead>
                <th>Manufacturer</th>
                <th>Model</th>
                <th>Year</th>
                <th>VIN</th>
                <th>Action</th>
                </thead>
                <tbody>
                <c:forEach var="car" items="${requestScope.carsList}">
                    <form action="cars" method="post">
                        <input name="clientId" value="${requestScope.client.id}" hidden/>
                        <input name="carId" value="${car.id}" hidden>
                        <tr onclick="location.href='orders?carId=${car.id}'">
                            <td>${car.make}</td>
                            <td>${car.model}</td>
                            <td>${car.year}</td>
                            <td>${car.vin}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${not empty car.orders}">
                                        <button rel="tooltip" data-placement="left"
                                                title="Unable to delete, car have some orders"
                                                class="btn btn-danger disabled" disabled>Del
                                        </button>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="submit" name="action" value="Del" class="btn btn-danger"/>
                                    </c:otherwise>
                                </c:choose>
                                <input type="submit" name="action" value="Edit" class="btn btn-warning"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <a href="clients" class="btn">Back</a>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</div>


</body>
</html>
