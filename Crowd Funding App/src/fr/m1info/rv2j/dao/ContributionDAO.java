package fr.m1info.rv2j.dao;

import java.util.List;

import fr.m1info.rv2j.beans.Contribution;

public interface ContributionDAO {

	/**
	 * Ajout de la contribution dans la base de données
	 * @param contributor : contributeur à ajouter
	 * @throws DAOException
	 */
	void create(Contribution contribution) throws DAOException;
	
	/**
	 * Recherche de la contribution portant l'id d'auteur
	 * @param id : id de l'auteur à rechercher
	 * @return une liste de contributions
	 * @throws DAOException
	 */
	List<Contribution> findByAuthorID(String author_id) throws DAOException;

	/**
	 * Recherche des contributions portant l'id de projet
	 * @param project_id : l'id de projet à rechercher
	 * @return une liste de contributions
	 * @throws DAOException
	 */
	List<Contribution> findByProjectID(String project_id) throws DAOException;
	
	/**
	 * Récupération de toutes les contributionsd dans la base de données
	 * @return une liste de contributions
	 * @throws DAOException
	 */
	List<Contribution> getAllContributions() throws DAOException;
	
}
