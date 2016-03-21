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
				margin-bottom: 25px;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
	
			 <%-- Vérification de la présence d'un objet utilisateur en session --%>
			<c:choose>
				<c:when test="${!empty sessionScope.session_user}">
					<div class="mdl-grid">
						<div class="mdl-cell mdl-cell--4-col">
							<div class="mdl-card mdl-shadow--2dp">
								<div class="mdl-card__title mdl-card--expand">
									<c:choose>
										<c:when test="${sessionScope.session_user.rightLevel == 2}">
											<h2 class="mdl-card__title-text">Bienvenue Administrateur</h2>
										</c:when>
										<c:when test="${sessionScope.session_user.rightLevel == 2}">
											<h2 class="mdl-card__title-text">Bienvenue</h2>
										</c:when>
									</c:choose>
								</div>
								<div class="mdl-card__supporting-text">
									<p>Username : ${sessionScope.session_user.name}</p>
									<p>Email : ${sessionScope.session_user.email}</p>
									<p>Date d'inscription : ${sessionScope.session_user.inscriptionDate}</p>
								</div>
							</div>
						</div>
						<div class="mdl-cell mdl-cell--4-col">
						</div>
						<div class="mdl-cell mdl-cell--4-col">
							<c:choose>
								<c:when test="${ !empty projects }">
									<c:forEach var="project" items="${projects}" >
										<div class="mdl-card mdl-shadow--2dp">
											<div class="mdl-card__title mdl-card--expand">
												<h2 class="mdl-card__title-text">${project.name}</h2>
											</div>
											<div class="mdl-card__supporting-text">
												<p>${project.presentation}</p>
											</div>
											<div class="mdl-card__actions mdl-card--border">
												<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="#">
													En savoir plus
												</a>
											</div>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<div class="mdl-card mdl-shadow--2dp">
										<div class="mdl-card__title mdl-card--expand">
											Pas de projet
										</div>
										<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
											Nouveau Projet...
										</a>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<p>Pas connecté ? Direction la page de connexion ! </p>
					<c:redirect url="/login"/>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>