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
    <a onclick="location.href='/document/add'">DODAj DOKUMENT</a>
    <a onclick="location.href='/document/viewFile'">INDEX DOKUMENT</a>
    <%--<a onclick="location.href='/file/add'">TEST</a>--%>
    <a onclick="location.href='/document/viewGallery2'">GALLERIA</a>
    <a onclick="location.href='/user/registr'">REJESTRACJA</a><%--<input type="button" value="Powrót">--%>
</nav>



