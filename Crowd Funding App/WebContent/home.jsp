<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Accueil</title>
		<%@include file="/WEB-INF/favicon.jsp" %>
		<link rel="stylesheet" href="<c:url value="/css/material.min.css"/>" />
		<script src="<c:url value="/js/material.min.js"/>" ></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<style>			
			.mdl-layout {
				align-items: right;
			}
			.mdl-layout__content {
				padding: 24px;
				flex: none;
			}
			.mdl-card {
				width: 70%;
			}
			body {
				background-image: url("resources/home.jpg");
				background-repeat: no-repeat;
				background-attachment: fixed;
				background-position: center;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
			<main class="mdl-layout__content">
				<div class="mdl-card mdl-shadow--4dp">
					<div class="mdl-card__title mdl-card--border">
						<h2 class="mdl-card__title-text">Un projet parmis tant d'autres...</h2>
					</div>
					<div class="mdl-card__title mdl-card--border">
						<h3 class="mdl-card__subtitle-text">
							TITRE PROJET	
						</h3>
					</div>
					<div class="mdl-card__supporting-text mdl-card--border">
						<p>
							<br/><br/>
								PRESENTATION PROJET
							<br/>
						</p>
					</div>	
					<div class="mdl-card__title mdl-card--border">
					</div>
					<div class="mdl-card__supporting-text mdl-card--border">	
						<p>
							<br/>
							EN SAVOIR PLUS
						</p>	
					</div>	
				</div>
			</main>
		</div>
	</body>
</html>