<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 18.09.2015
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="includes.jsp"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery-maskedinput/1.3.1/jquery.maskedinput.js" type="text/javascript"></script>
</head>
<body>

<script type="text/javascript">
    jQuery(function($){
        $("#phone").mask("+375 (99) 999-99-99");
    });
</script>

<div class="container">

    <jsp:include page="header.jsp"/>

    <div class="row" id="content">

        <jsp:include page="menu.jsp"/>

        <div class="span9">
            <legend>Add new Client</legend>

            <form action="clients" method="post">

                <table>
                    <tr>
                        <td><input name="name" type="text" placeholder="First Name" required/></td>
                    </tr>
                    <tr>
                        <td><input name="surname" type="text" placeholder="Last Name" required/></td>
                    </tr>
                    <tr>
                        <td><input name="birthday" type="date" placeholder="Date of birth" required/></td>
                    </tr>
                    <tr>
                        <td><input name="address" type="text" placeholder="Address" required/></td>
                    </tr>
                    <tr>
                        <td>
                            <input id="phone" name="phone" type="tel" pattern="+375 ([0-9]{2}) [0-9]{3}-[0-9]{2}-[0-9]{2}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td><input name="mail" type="email" placeholder="mail" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="action" value="Add" class="btn"/>
                            <a href="controller" class="btn">Back</a>
                        </td>
                    </tr>
                </table>

            </form>

        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</div>


</body>
</html>
