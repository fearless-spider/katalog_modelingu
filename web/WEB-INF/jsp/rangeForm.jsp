<%-- 
    Document   : rangeForm
    Created on : Jan 12, 2010, 2:27:49 PM
    Author     : uniqueblackrose
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
        <h1>Zakres pracy</h1>
        <form:form method="post">
                    <div class="t_label">
                        Zakres pracy :
                    </div>
                    <div class="t_box">
                        <form:input path="name" />
                    </div>
                    <div class="t_box">
                        <form:errors path="name" cssClass="error"/>
                    </div>
                    <div class="clr"></div>
                    <div class="t_box">
                        <input type="submit" name="submit" value="Zapisz"/>
                    </div>
        </form:form>
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
