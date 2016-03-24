<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
	<head>
		<%@include file="/WEB-INF/entete.jsp" %>
		<title>Mes contributions</title>
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
			<h1>Mes Contributions</h1>
			<c:choose>
				<c:when test="${!empty contributions}">
					<c:forEach var="contribution" items="${contributions}" >
						<div class="mdl-card mdl-shadow--4dp">
							<div class="mdl-card__title">
    							<h2 class="mdl-card__title-text">${contribution.creationDate}</h2>
    						</div>
    						<div class="mdl-card__supporting-text ">
								Donation de ${contribution.donation} € pour le projet 
								<a  href="
									<c:url value="/project">
										<c:param name="id" value="${contribution.projectID}"/>
									</c:url> ">
      								${projects[contribution.projectID].name}
    							</a>
 							</div>
  						</div>	
					</c:forEach>
				</c:when>
			</c:choose>
			<c:otherwise>
				<div class="mdl-card mdl-shadow--4dp">
					<div class="mdl-card__title">
    					<h2 class="mdl-card__title-text">Pas de contribution ?</h2>
					</div>
					<div class="mdl-card__actions mdl-card--border">
    					<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="<c:url value="/projects" />" >
      						Consultez les projets et lancez-vous !
    					</a>
  					</div>
  				</div>	
			</c:otherwise>
		</div>
	</body>
</html>