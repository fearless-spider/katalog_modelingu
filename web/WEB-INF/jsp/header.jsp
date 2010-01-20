<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><fmt:message key="title"/></title>
<meta name="keywords" content="<fmt:message key="keywords"/>" />
<meta name="description" content="<fmt:message key="description"/>" />
<link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<div id="logo">
            <h1><a href="<c:url value="index.htm" />"><fmt:message key="header"/></a></h1>
	</div>
	<hr />
	<!-- end #logo -->
	<div id="header">
		<div id="menu">
			<ul>
                            <li><a href="<c:url value="/index.htm" />" class="first">Strona główna</a></li>
                            <sec:authorize ifAllGranted="ROLE_ADMIN">
                            <li><a href="<c:url value="/admin/index.htm" />">Administracja</a></li>
                            </sec:authorize>
                            <sec:authorize ifAllGranted="ROLE_USER">
                            <li><a href="<c:url value="/users/myprofile/show.htm" />">Mój profil</a></li>
                            </sec:authorize>
                            <sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN">
                                <c:if test="${fn:length(groups) > 0}">
                            <li><a href="<c:url value="/register.htm" />">Dołącz</a></li>
                                </c:if>
                            </sec:authorize>
                            <li><a href="<c:url value="/about.htm" />">About</a></li>
                            <sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
                            <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                            </sec:authorize>
                            <sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN">
                            <li><a href="<c:url value="/login.htm" />">Login</a></li>
                            </sec:authorize>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="search">
		</div>
		<!-- end #search -->
	</div>
	<!-- end #header -->
	<!-- end #header-wrapper -->
