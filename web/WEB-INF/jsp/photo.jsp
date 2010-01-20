<%-- 
    Document   : userList
    Created on : 2009-10-31, 13:18:25
    Author     : Przemysław Pająk <bespider@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
                        <h1>Lista ${group.name}</h1>
                        <c:choose>
                        <c:when test="${fn:length(users) > 0}">
                        <table id="calendar">
                            <thead>
                                <tr>
                                    <th>Imię</th><th>Nazwisko</th><th>e-mail</th><th>Zakres pracy</th>
                                </tr>
                            </thead>
                            <tbody>
                        <c:forEach items="${users}" var="user" varStatus="status">
                            <tr>
                                <td>${user.firstname}</td>
                                <td>${user.lastname}</td>
                                <td>${user.email}</td>
                                <td>
                                    <table>
                                    <c:forEach items="${user.rangieses}" var="range" varStatus="status">
                                        <tr>
                                            <td>${range}</td>
                                        </tr>
                                    </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </c:forEach>
                            </tbody>
                        </table>
                        </c:when>
                            <c:otherwise>
                                <span class="error">Brak danych</span>
                            </c:otherwise>
                        </c:choose>
		</div>
		<!-- end #content -->
		<div id="sidebar">
<%@ include file="/WEB-INF/jsp/menu.jsp" %>
                </div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page -->
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
