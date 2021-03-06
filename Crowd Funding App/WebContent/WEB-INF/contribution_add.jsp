<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<%@include file="/WEB-INF/entete.jsp" %>
		<title>Contribution | ${projet.name}</title>
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
						<h2 class="mdl-card__title-text">Contribution à ${project.name}</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<strong>Attention</strong>, toute contribution est définitive !
						<form method="post" action="contribution_add">
							<input value="${project.ID}" type="hidden" id="id" name="id" required />
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="number" id="donation" name="donation" pattern=".{1,}" value="${project.name}" required />
								<label class="mdl-textfield__label" for="name">Montant (€)</label>
								<span class="mdl-textfield__error">${form.errors['donation']}</span>
							</div>
							<div class="mdl-card__actions mdl-card--border ">
								<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Contribuer !</button>
							</div>
						</form>
					</div>
				</div>
			</main>
		</div>
	</body>
</html>