# Crowd Funding App

## Projet de developpement Web - J2EE

- - -

Contributeurs :
* [COUASNET Robin](http://github.com/rcouasnet)
* [DEFAYE Johan](https://github.com/jdefaye)
* [DE LEEUW Valérian](http://github.com/vdeleeuw)
* [FOURMOND Jérôme](https://github.com/jfourmond)

- - -

### L'objectif

Le projet a pour caractéristiques :
	* Groupe de 4 étudiants (en dev. agile)
	* Sujets : site de crowdfunding (financement participatif)
	* Livrables :
		* 25 mars : .war de l’application avec les sources
		* 30 et 31 mars : Démo. + questions

1. Évaluation centrée sur la partie backend
2. Minimum : Servlets + JSP (JSTL et EL) + JDBC
3. Utilisation des frameworks encouragée
4. Frontend JQuery/Bootstrap fortement apprécié

---

### Présentation et rapport
Le site a été produit en **J2EE** en utilisant pour _Frontend_ : **Material Design Lite**. Aucun framework n'a été utilisé, chaque membre du groupe découvrant le **J2EE** il nous a semblé inadéquat d'utiliser directement des frameworks dans notre apprentissage sans en comprendre le fonctionnement, ou le fonctionnement de l'application.

Un _.war_ de l'application est disponible dans le répertoire [github](https://github.com/jfourmond/Crowd-Funding-App/blob/master/rv2j-j2ee.war).
Il est possible de l'ajouter dans le répertoire **webapps** de votre **tomcat** local.

Le site utilise une base de données **mysql** soutenue par une structure _DAO_.
Il pourrait être nécessaire de source le fichier [database.sql](https://github.com/jfourmond/Crowd-Funding-App/blob/master/Crowd%20Funding%20App/WebContent/WEB-INF/DB/database.sql) (*copy path dans git_hub*) dans mysql pour avoir une application au fonctionnement optimal.
	La commande, une fois dans l'invite de console **mysql** en tant qu'administrateur de la base de données :
		
		source [path-to-sql-file]
		
La base de données **fr_m1info_rv2j** utilisée ici est composée de différentes tables :
	**users**			contenant des utilisateurs
	**projects**		contenant des projets
	**contributions**	contenant des contributions
	**commentaries**	contenant des commentaires

Quatre **administrateurs** sont crées lors du source de la base de données :
<table>
	<tr>
		<td> Username </td>
		<td> Password </td>
	</tr>
	<tr>
		<td> Jerome </td>
		<td> Jeje </td>
	</tr>
	<tr>
		<td> Johan </td>
		<td> johan </td>
	</tr>
	<tr>
		<td> Robin </td>
		<td> roro </td>
	</tr>
	<tr>
		<td> Valerian </td>
		<td> valou </td>
	</tr>
</table>
Un utilisateur mysql est également crée avec les droits d'accès à la base de données **fr_m1info_rv2j**.
