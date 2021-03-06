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
        <div class="formPerson">
            <form:form method="post" modelAttribute="file" enctype="multipart/form-data">
                <form:errors path="*" cssClass="errorblock" element="div"/>
                <table id="addPersonTable">
                    <tr>
                        <td>Name:</td>
                        <td><form:input path="name"/></td>
                        <td><form:errors path="name" cssClass="error"/></td>
                    <%--</tr>--%>
                                      <%--<tr>--%>
                        <%--<td>File:</td>--%>
                        <%--<td><form:input type="file" path="files" /><td>--%>
                        <%--<td><form:errors path="files" /></td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td>File:</td>
                        <td><input type="file" name="file" /><td>
                    </tr>
                        <%--<tr>--%>
                        <%--<td>File name:</td>--%>
                        <%--<td><form:input path="file" /><td>--%>
                        <%--<td><form:errors path="file" /></td>--%>
                        <%--</tr>--%>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="Save"  onclick="location.href='../../..'"></td>
                    </tr>

                </table>
            </form:form>
        </div>


    </article>
</section>
<%@include file="../footer.jsp"%>
</body>
</html>
