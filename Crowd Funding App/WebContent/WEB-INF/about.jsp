<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>À propos</title>
		<%@include file="/WEB-INF/favicon.jsp" %>
		<link rel="stylesheet" href="<c:url value="/css/material.min.css"/>" />
		<script src="<c:url value="/js/material.min.js"/>" ></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<style>
			.mdl-layout__content {
				padding: 24px;
				flex: none;
			}
			.mdl-card {
				width: 100%;
			}
			.tab{
				line-height: 1.5;
				margin-left: 30px;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
			<main class="mdl-layout__content">
				<div class="mdl-card mdl-shadow--4dp">
					<div class="mdl-card__title mdl-card--border">
						<h2 class="mdl-card__title-text">À propos</h2>
					</div>
					<div class="mdl-card__title mdl-card--border">
						<h3 class="mdl-card__subtitle-text">
							<em>Site réalisé par : 
								<div class="tab"> 
									<a href="http://github.com/rcouasnet">COUASNET Robin</a>,<br/>
									<a href="http://github.com/vdeleeuw">DE LEEUW Valérian</a>,<br/> 
									<a href="https://github.com/jdefaye">DEFAYE Johan</a>,<br/>
									<a href="https://github.com/jfourmond">FOURMOND Jérome</a>.<br/>
								</div>
							</em>
						</h3>
					</div>
					<div class="mdl-card__supporting-text mdl-card--border">
						<p>
							<br/><br/>
							Nous avons réalisé ce mini site de financement participatif dans le cadre de la matière <strong>"Développement web avancé"</strong> dispensé par <em>DA MOTA Benoit</em>. <br/>
							Il utilise la technologie <strong>J2EE</strong>, c'était une grande première pour nous ! <br/>
							Le code du site est disponible sur le github <a href="https://github.com/jfourmond/Crowd-Funding-App">suivant</a>.<br/>
							Nous n'avons pas utilisé de frameworks, car personne ne connaissait encore le <strong>J2EE</strong> dans notre groupe !<br/>
							C'est pour cela que nous avons préféré d'abord apprendre par nous même les bases du <strong>J2EE</strong>.	<br/>
							Pour le front end nous avons utilisé <strong>material design lite</strong> qui est un css trouvable <a href="http://www.getmdl.io/index.html">ici</a>.<br/> 
							Pour le back end nous avons utilisé une base de données <strong>MySQL</strong> avec son <strong>DAO</strong>, des <strong>Servlets</strong>, des <strong>Beans</strong> et des <strong>Jsp</strong>.
							<br/>
						</p>
					</div>	
					<div class="mdl-card__title mdl-card--border">
					</div>
					<div class="mdl-card__supporting-text mdl-card--border">	
						<p>
							<br/>
							Si vous avez des questions ou des problèmes,	 n'hésitez pas à contacter l'un des webmasters aux adresses suivantes :
						</p>	
							<div class="tab"> 
								<a href="mailto:robin.couasnet@etud.univ-angers.fr?subject=J2EE-Crowdfunding">robin.couasnet@etud.univ-angers.fr</a>,<br/>
								<a href="mailto:valerian.deleeuw@etud.univ-angers.fr?subject=J2EE-Crowdfunding">valerian.deleeuw@etud.univ-angers.fr</a>,<br/> 
								<a href="mailto:johan.defaye@etud.univ-angers.fr?subject=J2EE-Crowdfunding">johan.defaye@etud.univ-angers.fr</a>,<br/>
								<a href="mailto:jerome.fourmond@etud.univ-angers.fr?subject=J2EE-Crowdfunding">jerome.fourmond@etud.univ-angers.fr</a>.<br/>
							</div>	
					</div>	
				</div>
			</main>
		</div>
	</body>
</html>