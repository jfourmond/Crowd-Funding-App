<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edition de projets</title>
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
				margin: auto;
			}
			.mdl-card {
				justify-content: center;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
			
			<main class="mdl-layout__content">
				<div class="mdl-card mdl-shadow--6dp">
					<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
						<h2 class="mdl-card__title-text">Projet ${project.ID}</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<form method="post" action="project_edit">
							<input hidden value="${project.ID}" type="text" id="id" name="id" required />
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="projectname" name="projectname" value="${project.name}" required />
								<label class="mdl-textfield__label" for="projectname">Nom</label>
								<span class="mdl-textfield__error">${form.errors['name']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<textarea class="mdl-textfield__input" type="text" rows= "3" id="presentation" name="presentation" value="${project.presentation}" required></textarea>
								<!-- <input class="mdl-textfield__input" type="text" id="presentation" name="presentation" value="${project.presentation}" required /> -->
								<label class="mdl-textfield__label" for="presentation">Présentation</label>
								<span class="mdl-textfield__error">${form.errors['presentation']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="number" id="goal" name="goal" value="${project.goal}" required />
								<label class="mdl-textfield__label" for="presentation">Objectif (€)</label>
								<span class="mdl-textfield__error">${form.errors['goal']}</span>
							</div>
							<div class="mdl-card__actions mdl-card--border ">
								<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Editer</button>
							</div>
						</form>
					</div>
				</div>
			</main>
		</div>
	</body>
</html>