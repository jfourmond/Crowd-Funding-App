package fr.m1info.rv2j.dao;

import java.util.List;

import fr.m1info.rv2j.beans.Commentary;

public interface CommentaryDAO {

	/**
	 * Création d'un commentaire dans la base de données
	 * @param commentary : commentaire à ajouter
	 * @throws DAOException
	 */
	void create(Commentary commentary) throws DAOException;
	
	/**
	 * Mise à jour du commentaire portant l'id dans la base de données
	 * @param id : id du commentaire à éditer
	 * @param commentary : commentaire de référence
	 * @throws DAOException
	 */
	void update(String id, Commentary commentary) throws DAOException;
	
	/**
	 * Récupération d'un commentaire par son id
	 * @param id : id du commentaire à récupérer
	 * @return NULL ou le commentaire
	 * @throws DAOException
	 */
	Commentary findByID(String id) throws DAOException;
	
	/**
	 * Récupération des commentaires par l'id du projet
	 * @param id : id du projet
	 * @return une liste de commentaires
	 * @throws DAOException
	 */
	List<Commentary> findByProjectID(String id) throws DAOException;
	
	/**
	 * Récupération de tous les commentaires dans la base
	 * @return une liste de commentaires
	 * @throws DAOException
	 */
	List<Commentary> getAllCommentaries() throws DAOException;
	
	/**
	 * Suppression d'un commentaire par son id
	 * @param id : id du commentaire à supprimer
	 * @throws DAOException
	 */
	void deleteByID(String id) throws DAOException;
	
	/**
	 * Compte du nombre de commentaires dans la base de données
	 * @return le nombre de commentaires dans la base de donénes
	 * @throws DAOException
	 */
	int count() throws DAOException;
	
}
