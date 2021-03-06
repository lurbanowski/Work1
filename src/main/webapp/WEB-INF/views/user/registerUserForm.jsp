<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 22.01.19
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0" >
    <title>Urbanowscy</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../style/style.css" >


</head>
<body>
<header class="Header">
    <%@include file="../header.jsp"%>
</header>

<div class="navX">
    <%@include file="../menu.jsp"%>
</div>


<section class="feature_area">
    <article id="content">

        <div class="panelLogin">
            <form:form method="post" modelAttribute="user">
                <form:errors path="*" cssClass="errorblock" element="div"/>
                <table>
                    <tr>
                        <td>Imię:</td>
                        <td><form:input path="userFirstName" /><td>
                        <td><form:errors path="userFirstName" /></td>
                    </tr>
                    <tr>
                        <td>Nazwisko:</td>
                        <td><form:input path="userLastName" /><td>
                        <td><form:errors path="userLastName" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><form:input path="email" /><td>
                        <td><form:errors path="email" /></td>
                    </tr>
                    <tr>
                        <td>Hasło:</td>
                        <td><form:input path="password" /><td>
                        <td><form:errors path="password" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="LOGIN"></td>
                    </tr>
                    <%--<tr>--%>
                        <%--<td>Email:</td>--%>
                        <%--<td><form:input path="email" /><td>--%>
                        <%--<td><form:errors path="email" /></td>--%>
                    <%--</tr>--%>

                </table>
            </form:form>
        </div>

    </article>
</section>
<%@include file="../footer.jsp"%>
</body>
</html>
