package fr.m1info.rv2j.dao;

import java.util.List;
import java.util.Map;

import fr.m1info.rv2j.beans.Project;

public interface ProjectDAO {
	/**
	 * Ajout d'un projet dans la base de données
	 * @param project : le projet à ajouter
	 * @throws DAOException
	 */
	void create(Project project) throws DAOException;
	
	/**
	 * Mise à jour du projet dans la base de données portant l'id
	 * @param id : id du projet
	 * @param project : projet utilisé pour la mise à jour
	 * @throws DAOException
	 */
	void update(String id, Project project) throws DAOException;
	
	/**
	 * Recherche d'un projet dans la base de données par son id 
	 * @param id : id du projet
	 * @return projet ou null
	 * @throws DAOException
	 */
	Project findByID(String id) throws DAOException;
	
	Project findByName(String name) throws DAOException;

	/**
	 * Recherche des projets dans la base de données par leur id d'auteur
	 * @param id : id de l'auteur du projet
	 * @return liste des projets
	 * @throws DAOException
	 */
	List<Project> findByAuthorID(String id) throws DAOException;
	
	/**
	 * Récupération de tous les projets dans la base de données
	 * @return liste des projets
	 * @throws DAOException
	 */
	List<Project> getAllProjects() throws DAOException;
	
	/**
	 * Récupération de tous les projets dans la base de données sous la forme d'un pair <id, projets>
	 * @return map des projets
	 * @throws DAOException
	 */
	Map<Integer, Project> mapProjects() throws DAOException;
	
	/**
	 * Suppression du projet dans la base de données portant l'id
	 * @param id : id du projet
	 * @throws DAOException
	 */
	void deleteByID(String id) throws DAOException;
	
	/**
	 * Compte du nombre de projets dans la base de données
	 * @return le nombre de projets dans la base de donénes
	 * @throws DAOException
	 */
	int count() throws DAOException;
}