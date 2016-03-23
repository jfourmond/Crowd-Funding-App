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
				<c:when test="${sessionScope.session_user.rightLevel == 1}">
					<a class="mdl-navigation__link" href="<c:url value="/projects"/>">Projets</a>
					<a class="mdl-navigation__link" href="<c:url value="/about"/>">A Propos</a>
					<a class="mdl-navigation__link" href="<c:url value="/logout" />">Déconnexion</a>
				</c:when>
				<c:when test="${sessionScope.session_user.rightLevel == 2}">
					<a class="mdl-navigation__link" href="<c:url value="/admin/users_list"/>">Utilisateurs</a>
					<a class="mdl-navigation__link" href="<c:url value="/admin/projects_list"/>">Projets</a>
					<a class="mdl-navigation__link" href="<c:url value="/admin/contributions_list"/>">Contributions</a>
					<a class="mdl-navigation__link" href="<c:url value="/logout" />">Déconnexion</a>
				</c:when>
				<c:otherwise>
					<a class="mdl-navigation__link" href="<c:url value="/about"/>">A Propos</a>
					<a class="mdl-navigation__link" href="<c:url value="/login"/>">Connexion</a>
					<a class="mdl-navigation__link" href="<c:url value="/signup"/>">Inscription</a>
				</c:otherwise>
			</c:choose>
		</nav>
	</div>
</header>
<c:choose>
	<c:when test="${sessionScope.session_user.rightLevel == 2}">
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">Menu</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="<c:url value ="/account" />">Mon Compte</a>
				<a class="mdl-navigation__link" href="<c:url value="/my_projects" />" >Mes projets</a>
				<a class="mdl-navigation__link" href="<c:url value="/project_add"/>">Nouveau Projet</a>
			</nav>
		</div>
	</c:when>
	<c:when test="${sessionScope.session_user.rightLevel == 1}">
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">Menu</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="<c:url value ="/account" />">Mon Compte</a>
				<a class="mdl-navigation__link" href="<c:url value="/my_projects" />" >Mes projets</a>
				<a class="mdl-navigation__link" href="<c:url value="/project_add"/>">Nouveau Projet</a>
			</nav>
		</div>
	</c:when>
</c:choose>
