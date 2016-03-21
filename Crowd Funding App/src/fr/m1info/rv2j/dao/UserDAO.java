package fr.m1info.rv2j.dao;

import java.util.List;

import fr.m1info.rv2j.beans.User;

public interface UserDAO {
	/**
	 * Ajout d'un utilisateur dans la base de données
	 * @param user : l'utilisateur à ajouter
	 * @throws DAOException
	 */
	void create(User user) throws DAOException;
	
	/**
	 * Mise à jour de l'utilisateur dans la base de données portant l'id
	 * @param id : id de l'utilisateur
	 * @param user : utilisateur utilisé pour la mise à jour
	 * @throws DAOException
	 */
	void update(String id, User user) throws DAOException;
	
	/**
	 * Recherche d'un utilisateur dans la base de données par son id 
	 * @param id : id de l'utilisateur
	 * @return utilisateur ou null
	 * @throws DAOException
	 */
	User findByID(String id) throws DAOException;
	
	/**
	 * Recherche d'un utilisateur par son nom
	 * @param name : nom de l'utilisateur à rechercher
	 * @return l'utilisateur trouvé
	 * @throws DAOException
	 */
	User findByName(String name) throws DAOException;
	
	/**
	 * Recherche d'un utilisateur par son email
	 * @param email : email de l'utilisateur à rechercher
	 * @return l'utilisateur trouvé
	 * @throws DAOException
	 */
	User findByEmail(String email) throws DAOException;
	
	/**
	 * Récupération de tous les utilisateurs dans la base de données
	 * @return liste des utilisateurs
	 * @throws DAOException
	 */
	List<User> getAllUsers() throws DAOException;
	
	/**
	 * Suppression d'un utilisateur par son id 
	 * @param id : id de l'utilisateur à supprimer
	 * @throws DAOException
	 */
	void deleteByID(String id) throws DAOException;
	
	/**
	 * Compte du nombre d'utilisateurs dans la base de données
	 * @return le nombre d'utilisateurs dans la base de donénes
	 * @throws DAOException
	 */
	int count() throws DAOException;
}
