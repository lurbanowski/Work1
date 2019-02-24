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

    <link href="/../style/lightgallery.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT" crossorigin="anonymous">
    </script>
    <script src="/../js/lightgallery-all.min.js"></script>



    <link rel="stylesheet" href="/../style/style.css" >
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
    <article class="Content" id="content">
        <div class="demo-gallery">
            <ul id="lightgallery" class="list-unstyled row">
                <c:forEach items="${file}" var="f">
                <li class="col-xs-6 col-sm-4 col-md-3" data-responsive="img/1-375.jpg 375, img/1-480.jpg 480, img/1.jpg 800" data-src="${f.path}" data-sub-html="<h4>Fading Light</h4><p>Classic view from Rigwood Jetty on Coniston Water an old archive shot similar to an old post but a little later on.</p>">
                    <a href="">
                        <img class="img-responsive" src="${f.path}">
                    </a>
                </li>
                    </c:forEach>
                <li class="col-xs-6 col-sm-4 col-md-3" data-responsive="img/2-375.jpg 375, img/2-480.jpg 480, img/2.jpg 800" data-src="../image/2.jpg" data-sub-html="<h4>Bowness Bay</h4><p>A beautiful Sunrise this morning taken En-route to Keswick not one as planned but I'm extremely happy I was passing the right place at the right time....</p>">
                    <a href="">
                        <img class="img-responsive" src="../image/2.jpg">
                    </a>
                </li>

            </ul>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT" crossorigin="anonymous"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('#lightgallery').lightGallery();
            });
        </script>
        <script src="/../js/lightgallery-all.min.js"></script>
    </article>
</section>

<%@include file="../footer.jsp"%>
</body>
</html>
