<%@ page pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="../WEB-INF/entete.jsp" %>
		<meta http-equiv="Refresh" content="1;url=<c:url value='/home' />">
		<title>You shouldn't be here...</title>
		<style>
			body {
				background-image: url("<c:url value='/resources/401.jpg' />");
				background-repeat: no-repeat;
				background-attachment: fixed;
				background-position: center;
				background-color: #000000;
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
		<p>Vous allez être automatiquement redirigé vers la page d'accueil.</p>
	</body>
</html>