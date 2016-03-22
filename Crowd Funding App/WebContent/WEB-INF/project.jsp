<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Projet | ${project.name}</title>
		<%@include file="/WEB-INF/favicon.jsp" %>
		<link rel="stylesheet" href="<c:url value="/css/material.min.css"/>" />
		<script src="<c:url value="/js/material.min.js"/>" ></script>
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
				width: 80%;
				margin:auto;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
		
			<main class="mdl-layout__content">
				<div class="mdl-card mdl-shadow--2dp">
					<div class="mdl-card__title mdl-card--border">
						<h2 class="mdl-card__title-text">${project.name}</h2>
					</div>
					<div class="mdl-card__title mdl-card--border">
						<h3 class="mdl-card__subtitle-text"><em>Proposé par : ${author.name}</em></h3>
					</div>
					<div class="mdl-card__title mdl-card--border">
						<h2 class="mdl-card__subtitle-text"><b>But : ${project.goal} €</b></h2>
					</div>
					<div class="mdl-card__supporting-text mdl-card--border">
						<p>
							${project.presentation}
						</p>
					</div>
					<div class="mdl-card__actions mdl-card--border">
						<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="
							<c:url value="#">
								<c:param name="id" value="${project.ID}"/>
							</c:url> ">
							Contribuer ! 
						</a>
					</div>
				</div>
			</main>
		</div>
	</body>
</html>