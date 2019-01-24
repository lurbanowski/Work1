<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 23.01.19
  Time: 08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<input type="checkbox" id="toggle"/>
<nav class="main-nav" id="nawigacja">
    <a onclick="location.href='/';">STRONA GŁÓWNA</a><%--<input type="button" value="Powrót">--%>
    <a onclick="location.href='/person/all'">INDEX ODÓB</a>
    <%--po zalogowaniu się--%>
    <a onclick="location.href='/person/add'">DODAj OSOBĘ</a>
    <a onclick="location.href='/user/registr'">REGISTER</a><%--<input type="button" value="Powrót">--%>
</nav>



