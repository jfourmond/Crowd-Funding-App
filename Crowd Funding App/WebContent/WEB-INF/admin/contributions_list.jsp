<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Liste des contributions</title>
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
			<h1>Contributions</h1>
			<form action="projects_list" method="post">
				<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
					<thead>
						<tr>
							<th>ID Auteur</th>
							<th>ID Projet</th>
							<th>Donation</th>
							<th class="mdl-data-table__cell--non-numeric">Date de contribution</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${ !empty contributions }">
								<c:forEach var="contribution" items="${contributions}" >
									<tr>
										<td>${contribution.userID}</td>
										<td>${contribution.projectID}</td>
										<td>${contribution.donation} €</td>
										<td class="mdl-data-table__cell--non-numeric">${contribution.creationDate}</td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</form>
		</div>
	</body>
</html>