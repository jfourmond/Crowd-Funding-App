<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Account</title>
		<%@include file="/WEB-INF/favicon.jsp" %>
		<link rel="stylesheet" href="css/material.min.css">
		<script src="js/material.min.js"></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<style>
			.mdl-layout {
				align-items: center;
			}
			.mdl-layout__content {
				padding: 24px;
				flex: none;
			}
			.mdl-card {
				justify-content: center;
			}
			body {
				background-color: #CEECF5;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
	
			 <%-- Vérification de la présence d'un objet utilisateur en session --%>
			<c:choose>
				<c:when test="${!empty sessionScope.session_user}">
					<c:if test="${sessionScope.session_user.rightLevel == 2}">
						<h1>Bienvenue Administrateur.</h1>
					</c:if>
					<p>Username : ${sessionScope.session_user.name}</p>
					<p>Email : ${sessionScope.session_user.email}</p>
					<p>Date d'inscription : ${sessionScope.session_user.inscriptionDate}</p>
				</c:when>
				<c:otherwise>
					<p>Pas connecté ? Direction la page de connexion ! </p>
					<c:redirect url="/login"/>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>