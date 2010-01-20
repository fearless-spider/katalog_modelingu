<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
                    <h1>Administracja</h1>
                    <h3><sec:authentication property="principal.username"/></h3>
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
