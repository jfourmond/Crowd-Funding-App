<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<%@include file="/WEB-INF/entete.jsp" %>
		<title>Connexion</title>
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
				background-image: url("resources/login.jpg");
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
						<h2 class="mdl-card__title-text">Connexion</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<form method="post" action="login">
							<p class="error">${form.errors['username']}</p>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="username" name="username" />
								<label class="mdl-textfield__label" for="username">Utilisateur</label>
								<span class="mdl-textfield__error">${form.errors['username']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="password" id="password" name="password" />
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
			</main>
		</div>
	</body>
</html>
