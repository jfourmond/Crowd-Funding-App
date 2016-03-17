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
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="../WEB-INF/headband.jsp" %>
	
			 <%-- Vérification de la présence d'un objet utilisateur en session --%>
			<c:choose>
				<c:when test="${!empty sessionScope.sessionUtilisateur}">
					<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
					<p>Vous êtes connecté(e) avec l'adresse ?</p>
				</c:when>
				<c:otherwise>
					<p>Pas connecté ? Direction la page de connexion ! </p>
					<c:redirect url="/login"/>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>