<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<%@include file="/WEB-INF/entete.jsp" %>
		<title>Projet | ${project.name}</title>
		<style>
			.mdl-layout__content {
				padding: 24px;
				flex: none;
			}
			.mdl-card {
				width: 80%;
			}
			.full-width {
				width: 100%;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
		
			<main class="mdl-layout__content">
			
				<div class="mdl-grid">
					 <div class="mdl-cell mdl-cell--8-col">
						<div class="mdl-card mdl-shadow--4dp">
							<div class="mdl-card__title mdl-card--border">
								<h2 class="mdl-card__title-text">${project.name}</h2>
							</div>
							<div class="mdl-card__title mdl-card--border">
								<h3 class="mdl-card__subtitle-text"><em>Proposé par : ${author.name}</em></h3>
							</div>
							<div class="mdl-card__title mdl-card--border">
								<h2 class="mdl-card__subtitle-text"><b>But : ${project.goal} €</b></h2>
							</div>
							<div class="mdl-card__supporting-text mdl-card--border">
								<p>
									${project.presentation}
								</p>
							</div>
						</div>
					</div>
					<div class="mdl-cell mdl-cell--4-col">
						<div class="mdl-card mdl-shadow--4dp">
							<div class="mdl-card__title mdl-card--border">
								<h2 class="mdl-card__title-text">Les dernières contributions</h2>
							</div>
							<div class="mdl-card__title mdl-card--border">
								<h4 class="mdl-card__subtitle-text"><c:out value="${donation_progress}" default="0" /> / ${project.goal} €</h4>
							</div>
							<div id="progress" class="mdl-progress mdl-js-progress"></div>
							<script>
								document.querySelector('#progress').addEventListener('mdl-componentupgraded', function() {
									this.MaterialProgress.setProgress(('${donation_progress}' * 100) / '${project.goal}');
								});
							</script>
							<c:choose>
								<c:when test="${ !empty contributions }">
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
														<td class="mdl-data-table__cell--non-numeric">
															Contribution de ${contribution.donation} €
														</td>
													</tr>	
												</c:forEach>
											</tbody>
										</table>
									</div>
									<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="
										<c:url value="/contribution_add">
											<c:param name="id" value="${project.ID}"/>
										</c:url> ">
										Pourquoi pas vous ?
									</a>
								</c:when>
								<c:otherwise>
									<a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="
										<c:url value="/contribution_add">
											<c:param name="id" value="${project.ID}"/>
										</c:url> ">
										Soyez le premier à contribuer !
									</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--4-col"></div>
					<div class="mdl-cell mdl-cell--6-col">
						<div class="mdl-card mdl-shadow--6dp">
							<div class="mdl-card__supporting-text">
								<form method="post" action="commentaries_add">
									<input value="${project.ID}" type="hidden" id="id" name="id" required />
									<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-width">
										<textarea class="mdl-textfield__input" type="text" id="comment" name="comment" rows="5" >${commentary.text}</textarea>
										<label class="mdl-textfield__label" for="comment">Un avis à donner ?</label>
									</div>
									<div class="mdl-card__actions mdl-card--border ">
										<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Commenter !</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="mdl-cell mdl-cell--4-col"></div>
				</div>
				
			</main>
		</div>
	</body>
</html>