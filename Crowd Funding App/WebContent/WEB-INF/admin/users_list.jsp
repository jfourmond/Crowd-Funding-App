<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Listes des utilisateurs</title>
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
	
			<h1>Utilisateurs</h1>
			<form action="users_list" method="post">
				<table class="mdl-data-table mdl-js-data-table">
					<thead>
						<tr>
							<th>ID</th>
							<th class="mdl-data-table__cell--non-numeric">Nom</th>
							<th class="mdl-data-table__cell--non-numeric">Mot de passe</th>
							<th class="mdl-data-table__cell--non-numeric">Email</th>
							<th class="mdl-data-table__cell--non-numeric">Date d'inscription</th>
							<th>Niveau de droit</th>
							<th><!-- BOUTON D'EDITION --></th>
							<th><!-- BOUTON DE SUPPRESSION --></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${ !empty users }">
								<c:forEach var="user" items="${users}" >
									<tr>
										<td>${user.ID}</td>
										<td class="mdl-data-table__cell--non-numeric">${user.name}</td>
										<td class="mdl-data-table__cell--non-numeric">${user.password}</td>
										<td class="mdl-data-table__cell--non-numeric">${user.email}</td>
										<td class="mdl-data-table__cell--non-numeric">${user.inscriptionDate}</td>
										<td>${user.rightLevel}</td>
										<td><button class="mdl-button mdl-js-button mdl-button--raised" type="submit" name="edit" value="${user.ID}">Editer</button></td>
										<td><button class="mdl-button mdl-js-button mdl-button--raised" type="submit" name="delete" value="${user.ID}">Supprimer</button></td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</form>
			<form action="users_list" method="post">
				<button class="mdl-button mdl-js-button mdl-button--fab" type="submit" name="add">
					<i class="material-icons">add</i>
				</button>
			</form>
		</div>
	</body>
</html>