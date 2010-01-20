<%-- 
    Document   : userForm
    Created on : 2009-10-21, 01:13:30
    Author     : Przemysław Pająk <bespider@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="my" uri="/catalog" %>

<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
                    <h1>Użytkownik</h1>
            <form:form method="post" >
                    <div class="t_label">
                        Użytkownik :
                    </div>
                    <c:choose>
                        <c:when test="${user.id != null}">
                    <div class="t_label">
                            ${user.username}
                    </div>
                        </c:when>
                        <c:otherwise>
                    <div class="t_box">
                            <form:input path="username" />
                    </div>
                    <div class="t_box">
                            <form:errors path="username" cssClass="error"/>
                    </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="clr"></div>
                    <div class="t_label">
                        Hasło :
                    </div>
                    <div class="t_box">
                        <form:password path="password" />
                    </div>
                    <div class="t_box">
                        <form:errors path="password" cssClass="error"/>
                    </div>
                    <div class="clr"></div>
                    <div class="t_label">
                        Potwierdź hasło :
                    </div>
                    <div class="t_box">
                        <form:password path="confirmpassword" />
                    </div>
                    <div class="t_box">
                        <form:errors path="confirmpassword" cssClass="error"/>
                    </div>
                    <div class="clr"></div>
                    <div class="t_label">
                        Imię :
                    </div>
                    <div class="t_box">
                        <form:input path="firstname" />
                    </div>
                    <div class="clr"></div>
                    <div class="t_label">
                        Nazwisko :
                    </div>
                    <div class="t_box">
                        <form:input path="lastname" />
                    </div>
                    <div class="clr"></div>
                    <div class="t_label">
                        E-mail :
                    </div>
                    <div class="t_box">
                        <form:input path="email" />
                        <input type="hidden" name="enabled" value="1" />
                    </div>
                    <div class="t_box">
                        <form:errors path="email" cssClass="error"/>
                    </div>
                    <div class="clr"></div>
                    <div class="t_label">
                        Grupa :
                    </div>
                    <div class="t_box">
                        <my:Groups nameTag="groups" groupId="${user.groups.id}" groups="${groupList}" />
                    </div>
                    <div class="clr"></div>
                    <div class="t_label">
                        Zakres współpracy :
                    </div>
                    <div class="t_box">
                            <my:Ranges nameTag="rangieses" ranges="${rangeList}" userRanges="${ranges}" />
                    </div>
                    <div class="clr"></div>
                    <div class="t_box">
                        <input type="submit" name="submit" value="Zapisz"/>
                    </div>
        </form:form>
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
