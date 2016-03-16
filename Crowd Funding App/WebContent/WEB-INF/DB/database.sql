/* DROP DATABASE si existe */
DROP DATABASE IF EXISTS fr_m1info_rv2j;
CREATE DATABASE fr_m1info_rv2j;
USE fr_m1info_rv2j;

/* DROP TABLE si existe */
DROP TABLE IF EXISTS compensations;
DROP TABLE IF EXISTS commentary;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS users;

/* BDD des utilisateur */
CREATE TABLE users(
	id INT(10) NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	pw VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	inscription_date DATE NOT NULL,
	PRIMARY KEY (id)
);

/* BDD des projets */
CREATE TABLE projects(
	id INT(10) NOT NULL AUTO_INCREMENT,
	author_id INT(10) NOT NULL,
	name VARCHAR(20) NOT NULL,
	contributors VARCHAR(500), 		/* Serialisable */
	compensations VARCHAR(500), 	/* Serialisable */
	creation_date DATE NOT NULL,
	last_update DATE NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (author_id) REFERENCES users(id)
);

/* BDD des commentaires */
CREATE TABLE commentary(
	id INT(10) NOT NULL AUTO_INCREMENT,
	author_id INT(10) NOT NULL,
	project_id INT(10) NOT NULL,
	text VARCHAR(140) NOT NULL, 	/* Comme un tweet :D */ 
	creation_date DATE NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (author_id) REFERENCES users(id),
	FOREIGN KEY (project_id) REFERENCES projects(id)
);

/* BDD des compensations */
CREATE TABLE compensations(
	id INT(10) NOT NULL AUTO_INCREMENT,
	threshold FLOAT(10) NOT NULL,
	project_id INT(10) NOT NULL,
	text VARCHAR(250) NOT NULL,
	contributor_limit INT(10) NOT NULL, 	/* 0 = illimité */
	contributors VARCHAR(500), 				/* Serialisable */
	PRIMARY KEY (id),
	FOREIGN KEY (project_id) REFERENCES projects(id)
);