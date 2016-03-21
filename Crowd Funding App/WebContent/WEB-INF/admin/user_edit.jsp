<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edition d'utilisateur</title>
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
						<h2 class="mdl-card__title-text">Utilisateur ${user.ID}</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<form method="post" action="user_edit">
							<input hidden value="${user.ID}" type="text" id="id" name="id" required />
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="username" name="username" value="${user.name}" required />
								<label class="mdl-textfield__label" for="username">Utilisateur</label>
								<span class="mdl-textfield__error">${form.errors['username']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="email" id="email" name="email" value="${user.email}" required/>
								<label class="mdl-textfield__label" for="email">Adresse E-mail</label>
								<span class="mdl-textfield__error">${form.errors['email']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="password" id="password" name="password" value="${user.password}" required />
								<label class="mdl-textfield__label" for="password">Mot de passe</label>
								<span class="mdl-textfield__error">${form.errors['password']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="right_level" name="right_level" value="${user.rightLevel}" pattern="[1-2]" required>
								<label class="mdl-textfield__label" for="right_level">Droit</label>
								<span class="mdl-textfield__error">1 ou 2</span>
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