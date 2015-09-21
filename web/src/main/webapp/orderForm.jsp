<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 21.09.2015
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="includes.jsp"/>
</head>
<body>

<legend>Add new Order</legend>

<form action="orders" method="post">
    <input name="carId" value="${requestScope.car.id}" hidden/>
    <input name="orderId" value="${requestScope.order.id}" hidden/>
    <table>
        <tr>
            <td><input name="date" type="date" value="${requestScope.order.date}" required/>
            </td>
        </tr>
        <tr>
            <td><input name="price" type="tel" pattern="(10|\d{1})(,\d{1,3})?" placeholder="Order Amount" title="0,0 - 10,000" value="${requestScope.order.price}" required/></td>
        </tr>
        <tr>
            <td>
                <select name="status" required>
                    <option value="${requestScope.order.status}" selected>${requestScope.order.status}</option>
                    <option id="completed" value="Completed">Completed</option>
                    <option id="inProgress" value="In Progress">In Progress</option>
                    <option id="canceled" value="Canceled">Canceled</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Save" class="btn"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
