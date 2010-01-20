<%-- 
    Document   : groupForm
    Created on : 2009-10-21, 09:12:05
    Author     : Przemysław Pająk <bespider@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="/catalog" prefix="my" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
                    <h1>Grupa</h1>
        <form:form method="post">
                    <div class="t_label">
                        Nazwa :
                    </div>
                    <div class="t_box">
                        <form:input path="name" />
                    </div>
                    <div class="t_box">
                        <form:errors path="name" cssClass="error"/>
                    </div>
                    <div class="clr"></div>
                    <div class="t_label">
                        Rola :
                    </div>
                    <div class="t_box">
                        <my:Authoritieses nameTag="authoritieses" authoritieses="${authoritieses}" authorityId="${authId}"/>
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
