<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edition d'un commentaire</title>
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
						<h2 class="mdl-card__title-text">Edition de commentaire</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<form method="post" action="project_add">
							<input value="${commentary.ID}" type="hidden" id="id" name="id" required />
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<textarea class="mdl-textfield__input" type="text" rows= "3" id="comment" name="comment" required>${commentary.text}</textarea>
								<label class="mdl-textfield__label" for="presentation">Texte du commentaire</label>
								<span class="mdl-textfield__error">${form.errors['comment']}</span>
							</div>
							<div class="mdl-card__actions mdl-card--border ">
								<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Ajouter</button>
							</div>
						</form>
					</div>
				</div>
			</main>
		</div>
	</body>
</html>