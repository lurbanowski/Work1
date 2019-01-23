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
    <article  id="content">
        <div class="formPerson">
            <form:form method="post" modelAttribute="person" >
                <form:errors path="*" cssClass="errorblock" element="div"/>
                <table id="addPersonTable">
                    <tr>
                        <td>Alive:</td>
                        <td><form:radiobutton path="alive" value="true"/>TAK</td>
                        <td><form:radiobutton path="alive" value="false"/>NIE</td>
                        <td><form:errors path="alive" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Family:</td>
                        <td><form:radiobutton path="family" value="true"/>TAK</td>
                        <td><form:radiobutton path="family" value="false"/>NIE</td>
                        <td><form:errors path="family" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>
                        <td><form:radiobutton path="gender" value="M"/>Mezczyzna</td>
                        <td><form:radiobutton path="gender" value="W"/>Kobieta</td>
                        <td><form:errors path="gender" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Imie:</td>
                        <td><form:input path="firstName" /><td>
                        <td><form:errors path="firstName" /></td>
                    </tr>
                    <tr>
                        <td>Nazwisko:</td>
                        <td><form:input path="lastName" /><td>
                        <td><form:errors path="lastName"/></td>
                    </tr>
                    <tr>
                        <td>Panieńskie nazwisko:</td>
                        <td><form:input path="maiden" /><td>
                        <td><form:errors path="maiden"/></td>
                    </tr>
                    <tr>
                        <td>Documenty:</td>
                        <td><input type="file" name="file" /></td>
                    </tr>
                    <%--<tr>--%>
                        <%--<td>Członek rodziny:</td>--%>
                        <%--<td><form:checkbox path="family" value="false"/>Nie</td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="Save"  onclick="location.href='/'"></td>
                    </tr>

                </table>
            </form:form>
        </div>

    </article>
</section>

<%@include file="../footer.jsp"%>
</body>
</html>
