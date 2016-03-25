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
    							<h2 class="mdl-card__title-text">Contributeurs du projet : &nbsp;
    								<a href="
	    								<c:url value="/project">
											<c:param name="id" value="${project.ID}"/>
										</c:url>
    								"> 
    									${project.name}
    								</a>
    							</h2>
    						</div>
    						<div class="mdl-card__supporting-text">
								<table>
									<thead>
										<tr>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="contribution" items="${contributions}" >
											<tr>									
												<c:choose>
													<c:when test="${project.ID == contribution.projectID}">
														<td class="mdl-data-table__cell--non-numeric">
															Donation de ${users[contribution.userID].name} à hauteur de ${contribution.donation} € 
														</td>
													</c:when>
												</c:choose>
											</tr>	
										</c:forEach>
									</tbody>
								</table>
  							</div>		
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
	      						Créez un projet et lancez-vous 
	    					</a>
	  					</div>
	  				</div>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>