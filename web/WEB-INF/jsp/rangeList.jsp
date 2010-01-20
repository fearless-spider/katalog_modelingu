<%--
    Document   : userList
    Created on : 2009-10-31, 13:18:25
    Author     : Przemysław Pająk <bespider@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
                    <h1>Zakresy pracy</h1>
                    <table id="calendar">
            <thead>
                <tr><th>Id</th><th>Nazwa</th><th>Data utworzenia</th><th>Data modyfikacji</th><th>Akcja</th></tr>
            </thead>
            <tbody>
        <c:forEach items="${rangeList}" var="range" varStatus="status">
                <tr>
                    <td>${range.id}</td>
                    <td>${range.name}</td>
                    <td>${range.created}</td>
                    <td>${range.modified}</td>
                    <td><a href="<c:url value="/admin/range/list.htm?id=${range.id}"/>">Usuń</a> | <a href="<c:url value="/admin/range/add.htm?id=${range.id}"/>">Edit</a></td>
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
