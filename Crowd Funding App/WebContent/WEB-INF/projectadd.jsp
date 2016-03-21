<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Project Add</title>
		<%@include file="/WEB-INF/favicon.jsp" %>
		<link rel="stylesheet" href="css/material.min.css">
		<script src="js/material.min.js"></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
				<style>
			.error {
				color: #B40431;
			}
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
			body {
				background-image: url("resources/projectadd.jpg");
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
				<div class="mdl-card mdl-shadow--6dp">
					<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
						<h2 class="mdl-card__title-text">Création d'un projet</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<form method="post" action="projectadd">
							<p class="error">${form.errors['username']}</p>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="author" name="author" />
								<label class="mdl-textfield__label" for="username">Auteur</label>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="name" name="name" />
								<label class="mdl-textfield__label" for="username">Nom de projet</label>
							</div>

							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="presentation" name="presentation" />
								<label class="mdl-textfield__label" for="text">Présentation</label>
							</div>
							<div class="mdl-textfield mdl-js-textfield">
							    <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="goal">
							    <label class="mdl-textfield__label" for="goal">Montant à atteindre</label>
							    <span class="mdl-textfield__error">Ceci n'est pas un nombre !</span>
							</div>
							<div class="mdl-card__actions mdl-card--border ">
								<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Terminer la création</button>
							</div>
						</form>
						<a href="signup">
							<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
								Créer un compte
							</button>
						</a>
					</div>
				</div>
			</main>
	</body>
</html>