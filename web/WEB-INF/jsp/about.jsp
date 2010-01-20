<%--
    Document   : accessDenied.jsp
    Created on : Jan 16, 2010, 7:08:28 PM
    Author     : uniqueblackrose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
			<div class="post">
				<div class="entry">
                                    <h3>Autor : Przemysław Pająk</h3>
                                    <h3>Nr Albumu: 131537</h3>
				</div>
			</div>
			<div class="post">
				<h2 class="title">O projekcie</h2>
				<p class="meta">Przemysław Pająk</p>
				<div class="entry">
                                    <p>Projekt jest webowym katalogiem modelingu. Katalog ten zawiera listy zarejestrowanych użytkowników podzielonych na grupy. Listy oglądać może każdy. Zarejestrować może się każdy.</p>
				</div>
			</div>
			<div class="post">
				<h2 class="title">Dane dostępowe</h2>
				<p class="meta">Przemysław Pająk</p>
				<div class="entry">
                                    <p>Do panelu admina może się zalogować używając poniższych danych:</p>
                                    <p>Użytkownik : admin</p>
                                    <p>Hasło : testtest</p>
				</div>
			</div>
			<div class="post">
				<h2 class="title">Dodatkowe</h2>
				<p class="meta">Przemysław Pająk</p>
				<div class="entry">
                                    <h3>Baza danych</h3>
                                    <ul>
                                        <li>MySQL 5.x</li>
                                        <li><a href="catalog.sql">Zrzut struktury bazy danych</a></li>
                                    </ul>
                                    <h3>Źródła</h3>
                                    <ul>
                                        <li><a href="https://www.hibernate.org/hib_docs/nhibernate/html/queryhql.html">HQL: The Hibernate Query Language</a></li>
                                        <li><a href="http://www.springsource.org/">Spring source</a></li>
                                        <li><a href="http://www.vaannila.com/">Vaannila</a></li>
                                        <li><a href="http://maestric.com/doc/java/spring/form_processing">Sample Form Processing</a></li>
                                        <li><a href="http://jasperforge.org/">JasperReports</a></li>
                                        <li><a href="http://j2ee.pl/2008/05/30/jasperreports-i-spring/">JasperReports i Spring</a></li>
                                    </ul>
				</div>
			</div>
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
