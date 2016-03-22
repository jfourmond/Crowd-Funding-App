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
			.mdl-layout__content {
				padding: 24px;
				flex: none;
			}
			.mdl-card {
				width: 80%;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
		
			<main class="mdl-layout__content">
			
				<div class="mdl-grid">
					 <div class="mdl-cell mdl-cell--8-col">
						<div class="mdl-card mdl-shadow--4dp">
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
						</div>
					</div>
					<div class="mdl-cell mdl-cell--4-col">
						<div class="mdl-card mdl-shadow--4dp">
							<div class="mdl-card__title mdl-card--border">
								<h2 class="mdl-card__title-text">Les dernières contributions</h2>
							</div>
							<c:choose>
								<c:when test="${ !empty contributions }">
									<div class="mdl-card__supporting-text">
										<ul class="mdl-list">
											<c:forEach var="contribution" items="${contributions}" >
												<li class="mdl-list__item">
													<span class="mdl-list__item-primary-content">Contribution de ${contribution.donation } €</span>
												</li>
											</c:forEach>
										</ul>
									</div>
									<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="
										<c:url value="/contribution_add">
											<c:param name="id" value="${project.ID}"/>
										</c:url> ">
										Pourquoi pas vous ?
									</a>
								</c:when>
								<c:otherwise>
									<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="
										<c:url value="/contribution_add">
											<c:param name="id" value="${project.ID}"/>
										</c:url> ">
										Soyez le premier à contribuer !
									</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</main>
		</div>
	</body>
</html>