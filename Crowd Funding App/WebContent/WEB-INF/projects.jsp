<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Listes des projets</title>
		<%@include file="/WEB-INF/favicon.jsp" %>
		<link rel="stylesheet" href="css/material.min.css">
		<script src="js/material.min.js"></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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
				margin: auto;
			}
			form {
				padding-top: 25px;
				width: 100%;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
			<h1>Projets</h1>
			<c:choose>
				<c:when test="${ !empty projects }">
					<c:forEach var="project" items="${projects}" >
						<div class="mdl-card mdl-shadow--4dp">
							<div class="mdl-card__title">
    							<h2 class="mdl-card__title-text">${project.name}</h2>
    							
    						</div>
    						<div class="mdl-card__supporting-text ">
								<!-- <h4>Par <b><em>${users[project.authorID-1].name}</em></b></h4> -->
								<p>${project.presentation}</p>
							</div>
							<div class="mdl-card__actions mdl-card--border">
    							<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="
									<c:url value="/project">
										<c:param name="id" value="${project.ID}"/>
									</c:url> ">
      								Contribuer ! 
    							</a>
  							</div>
  						</div>	
  						<!-- pas génial mais j'ai rien trouvé d'autre pour forcer un espace entre chaque projet -->
  						<div><p></p></div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
	</body>
</html>