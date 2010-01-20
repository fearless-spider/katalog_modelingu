<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
            <div id="content">
                <h1>Logowanie</h1>
                <form action="j_spring_security_check">
                    <div class="t_box">
                <c:if test="${not empty param.login_error}">
                    <span id="infomessage" class="error" >
    Login failed due to: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                    </span>
                </c:if>
                    </div>
                    <div class="clr"></div>
                    <div class="t_box">
                        <label for="j_username">Użytkownik</label>
                    </div>
                    <div class="t_box">
                        <input type="text" name="j_username" id="j_username" <c:if test="${not empty param.login_error}">value='${SPRING_SECURITY_LAST_USERNAME}'</c:if>/>
                    </div>
                    <div class="clr"></div>
                    <div class="t_box">
                        <label for="j_password">Hasło</label>
                    </div>
                    <div class="t_box">
                        <input type="password" name="j_password" id="j_password"/>
                    </div>
                    <div class="clr"></div>
                    <div class="t_box">
                        <input type='checkbox' name='_spring_security_remember_me'/> Zapamiętaj mnie na tym komputerze.
                    </div>
                    <div class="clr"></div>
                    <div class="t_box">
                        <input type="submit" value="Zaloguj"/>
                    </div>
                    <div class="clr"></div>
                </form>
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
