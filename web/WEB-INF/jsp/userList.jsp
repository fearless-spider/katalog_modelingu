<%-- 
    Document   : userList
    Created on : 2009-10-31, 13:18:25
    Author     : Przemysław Pająk <bespider@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
                        <h1>Lista użytkowników</h1>
                        <strong>Export danych:</strong>
                        <a href="?report=XML">XML</a> &middot;
                        <a href="?report=PDF">PDF</a>
                        <table id="calendar">
                            <thead>
                            <th>Użytkownik</th><th>Imię</th><th>Nazwisko</th><th>e-mail</th><th>Akcja</th>
                            </thead>
                            <tbody>
                        <c:forEach items="${users}" var="user" varStatus="status">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.firstname}</td>
                                <td>${user.lastname}</td>
                                <td>${user.email}</td>
                                <td><c:if test="${user.groups.authoritieses.id > 1}"><a href="<c:url value="/admin/user/list.htm?id=${user.id}"/>">Usuń</a> -|- </c:if><a href="<c:url value="/admin/user/add.htm?id=${user.id}"/>">Edit</a></td>
                                </tr>
                        </c:forEach>
                            </tbody>
                        </table>
		</div>
		<!-- end #content -->
		<div id="sidebar">
<%@ include file="/WEB-INF/jsp/menuAdmin.jsp" %>
                </div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page -->
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
