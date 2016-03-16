<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Connexion</title>
		<link rel="stylesheet" href="css/material.min.css">
		<script src="js/material.min.js"></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<style>
			.mdl-layout {
				align-items: center;
			  justify-content: center;
			}
			.mdl-layout__content {
				padding: 24px;
				flex: none;
			}
			
			body {
				background-image: url("resources/login.jpg");
				background-repeat: no-repeat;
				background-attachment: fixed;
				background-position: center;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout is-upgraded">
			<div class="mdl-card mdl-shadow--6dp">
				<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
					<h2 class="mdl-card__title-text">Connexion</h2>
				</div>
				<div class="mdl-card__supporting-text">
					<form method="post" action="login">
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" id="username" />
							<label class="mdl-textfield__label" for="username">Utilisateur</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="password" id="password" />
							<label class="mdl-textfield__label" for="password">Mot de passe</label>
						</div>
						<div class="mdl-card__actions mdl-card--border ">
							<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Connexion</button>
							<!-- <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Oubli ?</button> -->
						</div>
					</form>
					<a href="signup">
						<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
							Créer un compte
						</button>
					</a>
				</div>
			</div>
		</div>
	</body>
</html>
