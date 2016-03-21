<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Listes des projets</title>
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
			form {
				padding-top: 25px;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
			<h1>Projets</h1>
			<form action="projects_list" method="post">
				<table class="mdl-data-table mdl-js-data-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>ID Auteur</th>
							<th class="mdl-data-table__cell--non-numeric">Nom</th>
							<th class="mdl-data-table__cell--non-numeric">Présentation</th>
							<th>Goal</th>
							<th class="mdl-data-table__cell--non-numeric">Date de création</th>
							<th class="mdl-data-table__cell--non-numeric">Date de dernière mise à jour</th>
							<th><!-- BOUTON D'EDITION --></th>
							<th><!-- BOUTON DE SUPPRESSION --></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${ !empty projects }">
								<c:forEach var="project" items="${projects}" >
									<tr>
										<td>${project.ID}</td>
										<td>${project.authorID}</td>
										<td class="mdl-data-table__cell--non-numeric">${project.name}</td>
										<td class="mdl-data-table__cell--non-numeric">${project.presentation}</td>
										<td>${project.goal}</td>
										<td class="mdl-data-table__cell--non-numeric">${project.creationDate}</td>
										<td class="mdl-data-table__cell--non-numeric">${project.lastUpdateDate}</td>
										<td><button class="mdl-button mdl-js-button mdl-button--raised" type="submit" name="edit" value="${project.ID}">Editer</button></td>
										<td><button class="mdl-button mdl-js-button mdl-button--raised" type="submit" name="delete" value="${project.ID}">Supprimer</button></td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</form>
			<form action="projects_list" method="post">
				<button class="mdl-button mdl-js-button mdl-button--fab" type="submit" name="add">
					<i class="material-icons">add</i>
				</button>
			</form>
		</div>
	</body>
</html>