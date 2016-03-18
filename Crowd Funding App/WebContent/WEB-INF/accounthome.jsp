<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta content="text/html; charset=UTF-8">
		<title>Accueil Compte</title>
		<%@include file="/WEB-INF/favicon.jsp" %>
		<link type="text/css" rel="stylesheet" href="style.css" />
		<link rel="stylesheet" href="css/material.min.css">
		<script src="js/material.min.js"></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	</head>
	<body>
	
			<!-- headband's section -->
			<div>
				<%@include file="../WEB-INF/headband.jsp" %>
				</br>
			</div>
			
			<!-- introduction's section -->
			<div class="presentation">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ac molestie mauris. Aenean id erat mollis 
				velit malesuada mattis. Nunc lorem ipsum, eleifend ut nunc vitae, lobortis accumsan orci. Class aptent taciti 
				sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla rhoncus erat vitae metus lobortis 
				aliquam. Praesent consequat porta velit, vitae tristique sapien elementum ac. Pellentesque sit amet odio vel 
				mauris interdum faucibus a quis ante. Praesent nec nibh quis tellus volutpat vehicula. Suspendisse vel felis 
				eros. Donec consectetur laoreet velit, eu sollicitudin odio cursus ut. Lorem ipsum dolor sit amet, consectetur 
				adipiscing elit. Praesent ut tempus sem.
				</p>
			</div>
			
			<!-- project's list section -->
			<div class="listeProjets">
				<div class="mdl-grid">
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				  <div class="mdl-cell mdl-cell--1-col">1</div>
				</div>
				<div class="mdl-grid">
				  <div class="mdl-cell mdl-cell--4-col">4</div>
				  <div class="mdl-cell mdl-cell--4-col">4</div>
				  <div class="mdl-cell mdl-cell--4-col">4</div>
				</div>
				<div class="mdl-grid">
				  <div class="mdl-cell mdl-cell--6-col">6</div>
				  <div class="mdl-cell mdl-cell--4-col">4</div>
				  <div class="mdl-cell mdl-cell--2-col">2</div>
				</div>
				<div class="mdl-grid">
				  <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">6 (8 tablet)</div>
				  <div class="mdl-cell mdl-cell--4-col mdl-cell--6-col-tablet">4 (6 tablet)</div>
				  <div class="mdl-cell mdl-cell--2-col mdl-cell--4-col-phone">2 (4 phone)</div>
				</div>
			</div>	
	</body>
</html>