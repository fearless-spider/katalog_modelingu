<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
	<div id="page">
		<div id="content">
			<div id="banner"><img src="images/img09.jpg" alt="" /></div>
			<div class="post">
				<h2 class="title">Witaj w katalogu modelingu!</h2>
				<p class="meta">Przemysław Pająk</p>
				<div class="entry">
                                    <p>Katalog zawiera w sobie <strong>${groupcount}</strong> grupy i ${usercount} użytkowników.</p>
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
