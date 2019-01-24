<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 23.01.19
  Time: 08:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <label for='toggle'>&#9776;</label>
    <h2>URBANOWSCY</h2>
    <p>Geneaologia rodziny</p>

<div class="csslogin2">
    <c:choose>
        <c:when test="${empty sessionScope.userSesion or sessionScope.userSesion == null}">
            <div>
                <form method="post" action="/user/login">
                    <input type="text" name="email" placeholder="email">
                    <input type="text" name="password" placeholder="password">
                    <input type="submit" name="LOGIN" ></td>
                </form>

            </div>

        </c:when>
        <c:otherwise>
            Witaj ${imie}
            <td><button><a onclick="location.href='/user/logout';">LOGOUT</a></button></td>
        </c:otherwise>
    </c:choose>
</div>
    <%--<c:if test="${empty session.userSesion}">--%>
        <%--<div>--%>
    <%--<form method="post" action="/user/login">--%>
       <%--<input type="text" name="email" placeholder="email">--%>
       <%--<input type="text" name="password" placeholder="password">--%>
        <%--<input type="submit" name="LOGIN" ></td>--%>
    <%--</form>--%>

    <%--</div>--%>
<%--</c:if>--%>
<%--<c:if test="${not empty session.userSesion}">--%>
    <%--Witaj ${imie}--%>
    <%--<td><button href="/user/logout"><a onclick="location.href='/user/logout';">LOGOUT</a></button></td>--%>
    <%--&lt;%&ndash;<%@ page session="false" %>&ndash;%&gt;--%>
    <%--&lt;%&ndash;${sessionScope==null}&ndash;%&gt;--%>
<%--</c:if>--%>


    <%--<div class="csslogin2">--%>
       <%--<form:form method="post" modelAttribute="user" action="/user/login">--%>
           <%--<form:errors path="*"/> &lt;%&ndash;cssClass="errorblock" element="div"&ndash;%&gt;--%>
            <%--<table>--%>
          <%----%>
                <%--<tr>--%>
                    <%--<td>Email:</td>--%>
                    <%--<td><form:input path="email" /><td>--%>
                    <%--<td><form:errors path="email" /></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>Password:</td>--%>
                    <%--<td><form:input path="password" /><td>--%>
                    <%--<td><form:errors path="password" /></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><input type="submit" name="X" ></td>--%>
                    <%--<td> <a href="/registr">REGISTER</a></td>--%>
                    <%--<td><button href="/user/registr">REGISTER</button></td>--%>
                <%--</tr>--%>
           <%----%>
           <%----%>
            <%--&lt;%&ndash;${empty sessionScope.values() ? "empty" : "Witaj " ${imie}}&ndash;%&gt;--%>
            <%--</table>--%>

       <%--</form:form>--%>
    <%--</div>--%>
