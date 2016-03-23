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
								${project.presentation}
							</div>
  						</div>	
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
	</body>
</html>