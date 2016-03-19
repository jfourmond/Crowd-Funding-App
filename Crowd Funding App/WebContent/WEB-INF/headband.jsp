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
			<c:choose>
				<c:when test="${sessionScope.session_user.right_level == 1}">
					<a class="mdl-navigation__link" href="<c:url value="#"/>">Compte</a>
					<a class="mdl-navigation__link" href="<c:url value="#"/>">Projet</a>
					<a class="mdl-navigation__link" href="<c:url value="/logout" />">D�connexion</a>
				</c:when>
				<c:when test="${sessionScope.session_user.right_level == 2}">
					<a class="mdl-navigation__link" href="<c:url value="#"/>">Administration</a>
					<a class="mdl-navigation__link" href="<c:url value="/logout" />">D�connexion</a>
				</c:when>
				<c:otherwise>
					<a class="mdl-navigation__link" href="<c:url value="/login"/>">Connexion</a>
					<a class="mdl-navigation__link" href="<c:url value="/signup"/>">Inscription</a>
				</c:otherwise>
			</c:choose>
		</nav>
	</div>
</header>
<div class="mdl-layout__drawer">
	<span class="mdl-layout-title">Menu</span>
	<nav class="mdl-navigation">
		<a class="mdl-navigation__link" href="">D�couvrir</a>
		<a class="mdl-navigation__link" href="<c:url value="/home"/>">Retour � l'accueil</a>
	</nav>
</div>