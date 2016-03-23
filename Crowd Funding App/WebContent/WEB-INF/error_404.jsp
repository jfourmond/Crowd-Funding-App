<%@ page pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html >
<html>
	<head>
		<%@include file="/WEB-INF/entete.jsp" %>
		<meta http-equiv="Refresh" content="2;url=<c:url value="/home" />">
		<title>Are you lost ?</title>
		<style>
			body {
				background-image: url("<c:url value='/resources/404.png' />");
				background-repeat: no-repeat;
				background-attachment: fixed;
				background-position: center;
				background-color: #222222;
			}
			p {
				color: white;
				padding:auto;
				position:absolute;
				bottom:0px;
			}
		</style>
	</head>
	<body>
		<!-- Merci Florentin <3 -->
		<p>Vous allez être automatiquement redirigé vers la page d'accueil.</p>
	</body>
</html>