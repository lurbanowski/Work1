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
    <link rel="stylesheet" href="../style/style.css" >
    <link rel="stylesheet" href="/../style/style.css" >
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<header class="Header">
    <%--<%@include file="../header.jsp"%>--%>
</header>

<div class="navX">
    <%@include file="../menu.jsp"%>
</div>
<section class="feature_area">
    <article class="Content" id="content">

        <h2>Indeks odób w bazie</h2>
        <div class="viewPerson">
            <table >
                <tr>
                    <td><b>Id</b></td>
                    <td><b>Imię</b></td>
                    <td><b>Nazwisko</b></td>
                    <td><b>Panieńskie</b></td>
                    <td><b>Osoba żyjąca</b></td>
                </tr>
                <c:forEach items="${person}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.firstName}</td>
                        <td>${p.lastName}</td>
                        <td>${p.maiden}</td>
                        <td>${p.alive}</td>
                        <td><button data-id='${p.id}' class="test" >Szczególy</button></td>
                        <td><button onclick="location.href='/person/edit/${p.id}'">Edit</button></td>
                        <%--<td><button onclick="$('#content').load('/person/edit/${p.id}')">Edytuj</button></td>--%>
                        <%--<td><button onclick="$('#content').load('/person/delete/${p.id}')">Usuń</button></td>--%>

                    </tr>
                    <tr id="hiddenSzczegoly${p.id}" class="hs"><td>
                                    <td>Famili: ${p.family}</td>
                                    <td>Gender: ${p.gender}</td>
                                    <td>Documents:
                                                    <c:forEach items="${p.document}" var="d">
                                            <tr>
                                                <td>${d.name}</td>
                                            </tr>
                                            <tr>
                                                <td>Type:</td>
                                                <td>${file.contentType}</td>
                                            </tr>
                                            </c:forEach>

                                     </td>
                    </tr>
                    <%--<tr id="hidden2Szczegoly${p.id}" class="hs">--%>
                    <%----%>
                    <%--</tr>--%>
                </c:forEach>
            </table>
        </div>

        <script type="text/javascript">
            $(document).ready(function(){
                $('.test').click(function(e){
                    var z = $(this).data('id');
                    // var y = $(this).data('edit');
                    $('#hiddenSzczegoly'+z).toggleClass("hs");});
                    // $('#hidden2Szczegoly'+y).toggleClass("hs");
            });

            // $(document).ready(function(){
            //     $('.test1').click(function(e){
            //         var z = $(this).data('edit');
            //         $('#hiddenSzczegoly'+y).toggleClass("hs");});
            // });
        </script>
    </article>
</section>

<%@include file="../footer.jsp"%>
</body>
</html>
