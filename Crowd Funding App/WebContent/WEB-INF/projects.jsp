<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<%@include file="/WEB-INF/entete.jsp" %>
		<title>Listes des projets</title>
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
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
			<h1>Projets</h1>
			<c:choose>
				<c:when test="${ !empty projects }">
					<c:forEach var="project" items="${	projects}" >
						<div class="mdl-card mdl-shadow--4dp">
							<div class="mdl-card__title">
    							<h2 class="mdl-card__title-text">${project.name}</h2>
    							
    						</div>
    						<div class="mdl-card__supporting-text ">
								${project.presentation}
							</div>
							<div class="mdl-card__actions mdl-card--border">
    							<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="
									<c:url value="/project">
										<c:param name="id" value="${project.ID}"/>
									</c:url> ">
      								En savoir plus 
    							</a>
  							</div>
  						</div>	
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
	</body>
</html>