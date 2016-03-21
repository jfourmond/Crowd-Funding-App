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
						<form method="post" action="user_edit">
							<input hidden value="${project.ID}" type="text" id="id" name="id" required />
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="projectname" name="projectname" value="${project.name}" required />
								<label class="mdl-textfield__label" for="projectname">Nom</label>
								<span class="mdl-textfield__error">${form.errors['name']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="author_id" name="author_id" value="${project.author_id}" disabled="disabled" required/>
								<label class="mdl-textfield__label" for="author_id">ID Auteur</label>
								<span class="mdl-textfield__error">${form.errors['author_id']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="presentation" name="presentation" value="${project.presentation}" required />
								<label class="mdl-textfield__label" for="presentation">Présentation</label>
								<span class="mdl-textfield__error">${form.errors['presentation']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="number" id="goal" name="goal" value="${project.goal}" required />
								<label class="mdl-textfield__label" for="presentation">Objectif (€)</label>
								<span class="mdl-textfield__error">${form.errors['goal']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="date" id="creation_date" name="creation_date" value="${project.creation_date}" disabled="disabled" required />
								<label class="mdl-textfield__label" for="presentation">Date de création</label>
								<span class="mdl-textfield__error">${form.errors['creation_date']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="date" id="last_update_date" name="last_update_date" value="${project.last_update_date}" disabled="disabled" required />
								<label class="mdl-textfield__label" for="presentation">Dernière édition</label>
								<span class="mdl-textfield__error">${form.errors['last_update_date']}</span>
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