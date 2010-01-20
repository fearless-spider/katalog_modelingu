<%-- 
    Document   : myProfile
    Created on : Jan 16, 2010, 6:31:41 PM
    Author     : uniqueblackrose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
                        <h1>Witaj <sec:authentication property="principal.username"/></h1>
                        <h3>Profil : </h3><a href="<c:url value="/users/myprofile/edit.htm" />">Edit</a>
                        <table id="calendar">
                            <tbody>
                                <tr>
                                    <td>Imię</td><td><c:out value="${user.firstname}" /></td>
                                </tr>
                                <tr>
                                    <td>Nazwisko</td><td><c:out value="${user.lastname}" /></td>
                                </tr>
                                <tr>
                                    <td>e-mail</td><td><c:out value="${user.email}" /></td>
                                </tr>
                                <tr>
                                    <td>Grupa</td><td><c:out value="${group.name}" /></td>
                                </tr>
                                <tr>
                                    <td colspan="2">Zakres pracy</td>
                                </tr>
                                <c:forEach items="${ranges}" var="range" varStatus="status">
                                <tr>
                                    <td colspan="2"><c:out value="${range.name}" /></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
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
