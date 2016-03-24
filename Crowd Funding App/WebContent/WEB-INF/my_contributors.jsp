<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
	<head>
		<%@include file="/WEB-INF/entete.jsp" %>
		<title>Mes contributeurs</title>
		<style>
			.mdl-layout {
				align-items: center;
			}
			.mdl-layout__content {
				padding: 24px;
				flex: none;
			}
			.mdl-card {
				width: 60%;
				margin-top: 20px;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
			<h1>Mes Contributeurs</h1>
			<c:choose>
				<c:when test="${!empty projects}">
					<c:forEach var="project" items="${projects}" >
						<div class="mdl-card mdl-shadow--4dp">
							<div class="mdl-card__title">
    							<h2 class="mdl-card__title-text">${project.name}</h2>
    						</div>
							<c:forEach var="contribution" items="${contributions}" >
								<c:choose>
								<c:when test="${project.ID == contribution.projectID}">
		    						<div class="mdl-card__supporting-text ">
										Donation de ${users[contribution.userID].name} à hauteur de ${contribution.donation} € 
										<a  href="
											<c:url value="/project">
												<c:param name="id" value="${contribution.projectID}"/>
											</c:url> ">
		      								${projects[contribution.projectID].name}
		    							</a>
		 							</div>
 							</c:when>
 							</c:choose>
  						</c:forEach>
  						</div>	
  					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="mdl-card mdl-shadow--4dp">
						<div class="mdl-card__title">
	    					<h2 class="mdl-card__title-text">Pas de contributeurs ?</h2>
						</div>
						<div class="mdl-card__actions mdl-card--border">
	    					<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="<c:url value="/project_add" />" >
	      						Creez un projet et lancez-vous 
	    					</a>
	  					</div>
	  				</div>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>