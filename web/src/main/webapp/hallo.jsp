<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 17.09.2015
  Time: 19:42
  To change this template use File | Settings | File Templates.

  Hallo page
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

            <a href="addClient.jsp" class="btn">Add New Client</a>
            <a href="search.jsp" class="btn">Search Client</a>

        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>
