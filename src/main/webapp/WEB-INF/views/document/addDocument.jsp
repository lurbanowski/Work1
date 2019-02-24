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
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


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
            <form:form method="post" modelAttribute="dokument" enctype="multipart/form-data">
                <form:errors path="*" cssClass="errorblock" element="div"/>
                <h2>NOWY DOKUMENT</h2>
                <tr id="addPersonTable">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><form:input path="name"/></td>
                        <td><form:errors path="name" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Type:</td>
                        <td><form:input path="type" /></td>
                        <td><form:errors path="type" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Person:</td>
                        <td>
                            <form:select path="person" >
                                <form:option value="" label="Wybierz osobę"/>
                                <form:options items="${persons}" itemValue="id" itemLabel="id"/>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>Date:</td>
                        <td><form:input type="date" path="createDate" /></td>
                        <td><form:errors path="createDate" cssClass="error"/></td>
                    </tr>


                    <tr>
                        <td>File:</td>
                        <td><input type="file" name="file"/></td>
                        <td><button type="button" data-id='1' class="test" >Kolejny</button></td>
                    </tr>

                    <tr id="hiddenSzczegoly1" class="hs">
                        <td>File:</td>
                        <td><input type="file" name="file"/></td>
                        <td><button type="button" data-id='2' class="test">Kolejny</button></td>
                    </tr>
                    <tr id="hiddenSzczegoly2" class="hs">
                        <td>File:</td>
                        <td><input type="file" name="file"/></td>
                    </tr>
                   <tr>
                       <td></td>
                        <td><input type="submit" name="Save"  onclick="location.href='/'"></td>
                    </tr>

                </table>
            </form:form>
        </div>
        <script type="text/javascript">
            $(document).ready(function(){
                $('.test').click(function(e){
                    var z = $(this).data('id');

                    $('#hiddenSzczegoly'+z).toggleClass("hs");});

            });
        </script>

    </article>
</section>
<%@include file="../footer.jsp"%>
</body>
</html>
