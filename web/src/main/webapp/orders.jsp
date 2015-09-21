<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 19.09.2015
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="includes.jsp"/>
</head>
<body>

<div class="container">

    <jsp:include page="header.jsp"/>

    <div class="row" id="content">

        <jsp:include page="menu.jsp"/>

        <div class="span9">

            <jsp:include page="orderForm.jsp"/>

            <legend>All Orders by Car: ${requestScope.car.make} - ${requestScope.car.model}    VIN:${requestScope.car.vin}</legend>

            <table class="table table-striped table-hover table-bordered">
                <thead>
                <th>Date</th>
                <th>Order Amount</th>
                <th>Order Status</th>
                <th>Action</th>
                </thead>
                <tbody>
                <c:forEach var="order" items="${requestScope.orderList}">
                    <form action="orders" method="post">
                        <input name="carId" value="${requestScope.car.id}" hidden/>
                        <input name="orderId" value="${order.id}" hidden/>
                        <tr>
                            <td>${order.date}</td>
                            <td>${order.price}</td>
                            <td>${order.status}</td>
                            <td>
                                <input type="submit" name="action" value="Del" class="btn btn-danger"/>
                                <input type="submit" name="action" value="Edit" class="btn btn-warning"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <a href="cars?clientId=${requestScope.car.client.id}" class="btn">Back</a>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>