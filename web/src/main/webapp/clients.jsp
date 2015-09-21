<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 17.09.2015
  Time: 20:26
  To change this template use File | Settings | File Templates.

  Page list of Clients with include pagination

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
            <input name="page" value="${currentPage}" hidden>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <th>Name</th>
                <th>Surname</th>
                <th>Birthday</th>
                <th>Address</th>
                <th>Mail</th>
                <th>Phone</th>
                </thead>
                <tbody>
                <c:forEach var="client" items="${requestScope.clientList}">
                    <tr onclick="location.href='cars?clientId=${client.id}'">
                        <td>${client.name}</td>
                        <td>${client.surname}</td>
                        <td>${client.birthday}</td>
                        <td>${client.address}</td>
                        <td>${client.mail}</td>
                        <td>${client.phone}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <jsp:include page="pagination.jsp"/>

    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>
