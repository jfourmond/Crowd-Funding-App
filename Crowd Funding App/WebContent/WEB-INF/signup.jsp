<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<%@include file="/WEB-INF/entete.jsp" %>
		<title>Inscription</title>

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
				background-image: url("resources/signup.jpg");
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
							<h2 class="mdl-card__title-text">Inscription</h2>
						</div>
					<div class="mdl-card__supporting-text">
						<form method="post" action="signup">
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="username" name="username" pattern=".{5,}" required title="5 caractères minimum"/>
								<label class="mdl-textfield__label" for="username">Utilisateur</label>
								<span class="mdl-textfield__error">${form.errors['username']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="email" id="email" name="email" pattern=".{6,}" required/>
								<label class="mdl-textfield__label" for="email">Adresse E-mail</label>
								<span class="mdl-textfield__error">${form.errors['email']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="password" id="password" name="password" pattern=".{6,}" required title="6 caractères minimum"/>
								<label class="mdl-textfield__label" for="password">Mot de passe</label>
								<span class="mdl-textfield__error">${form.errors['password']}</span>
							</div>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="password" id="password_conf" name="password_conf" required />
								<label class="mdl-textfield__label" for="password_conf">Confirmation mot de passe</label>
							</div>
							<div class="mdl-card__actions mdl-card--border ">
								<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Inscription</button>
							</div>
						</form>
						<a href="login">
							<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
								Se connecter
							</button>
						</a>
					</div>
				</div>
			</main>
		</div>
	</body>
</html>
