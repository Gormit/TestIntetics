<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 21.09.2015
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="includes.jsp"/>
</head>
<body>

<legend>Add new Car</legend>

<form action="cars" method="post">
    <input name="clientId" value="${requestScope.client.id}" hidden/>
    <input name="carId" value="${requestScope.car.id}" hidden/>
    <table>
        <tr>
            <td><input name="make" type="text" placeholder="Manufacturer" value="${requestScope.car.make}" required/>
            </td>
        </tr>
        <tr>
            <td><input name="model" type="text" placeholder="Model" value="${requestScope.car.model}" required/></td>
        </tr>
        <tr>
            <td><input name="year" type="text" placeholder="Year xxxx" pattern="[0-9]{4}" value="${requestScope.car.year}" required/></td>
        </tr>
        <tr>
            <td><input id="vin" name="vin" type="text" placeholder="VIN 17 chars" pattern="^[A-HJ-NPR-Z0-9]{17}" value="${requestScope.car.vin}" required/></td>
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

