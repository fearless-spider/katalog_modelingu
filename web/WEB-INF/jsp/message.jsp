<%-- 
    Document   : message
    Created on : 2009-10-21, 01:13:30
    Author     : Przemysław Pająk <bespider@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
                    <h1>Wiadomość</h1>
                    <h3>${message}</h3>
		</div>
		<!-- end #content -->
		<div id="sidebar">
                    <sec:authorize ifNotGranted="ROLE_ADMIN">
<%@ include file="/WEB-INF/jsp/menu.jsp" %>
                    </sec:authorize>
                    <sec:authorize ifAllGranted="ROLE_ADMIN">
<%@ include file="/WEB-INF/jsp/menuAdmin.jsp" %>
                    </sec:authorize>
                </div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page -->
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
