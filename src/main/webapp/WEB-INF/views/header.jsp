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

<%--<div >--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td><a href="/user/login"</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <%----%>
<%--</div>--%>


    <div class="csslogin2">
       <form:form method="post" modelAttribute="user" action="/user/login">
           <form:errors path="*"/> <%--cssClass="errorblock" element="div"--%>
            <table>
            <%--<c:if test="${empty sessionScope}">--%>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email" /><td>
                    <td><form:errors path="email" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="password" /><td>
                    <td><form:errors path="password" /></td>
                </tr>
                <tr>
                    <td><input type="submit" name="X" ></td>
                    <td> <a href="/registr">REGISTER</a></td>
                    <%--<td><button href="/user/registr">REGISTER</button></td>--%>
                </tr>
            <%--</c:if>--%>
            <c:if test="${not empty sessionScope}">
                Witaj ${imie}
                <td><button href="/logout">LOGOUT</button></td>
            </c:if>
            <%--${empty sessionScope.values() ? "empty" : "Witaj " ${imie}}--%>
            </table>

       </form:form>
    </div>
