<header class="mdl-layout__header">
	<div class="mdl-layout__header-row">
		<!-- Title -->
		<a class="mdl-navigation__link" href="<c:url value="/home"/>">
			<span class="mdl-layout-title">
				Crowd-Funding
			</span>
		</a>
		<!-- Add spacer, to align navigation to the right -->
		<div class="mdl-layout-spacer"></div>
			<!-- Navigation. We hide it in small screens. -->
			<nav class="mdl-navigation mdl-layout--large-screen-only">
				<a class="mdl-navigation__link" href="<c:url value="/login"/>">Connexion</a>
				<a class="mdl-navigation__link" href="<c:url value="/signup"/>">Inscription</a>
			</nav>
	</div>
</header>
<div class="mdl-layout__drawer">
	<span class="mdl-layout-title">Menu</span>
	<nav class="mdl-navigation">
		<a class="mdl-navigation__link" href="">Découvrir</a>
		<a class="mdl-navigation__link" href="<c:url value="/home"/>">Retour à l'accueil</a>
	</nav>
</div>