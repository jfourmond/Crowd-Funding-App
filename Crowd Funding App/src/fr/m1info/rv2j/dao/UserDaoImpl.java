package fr.m1info.rv2j.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.m1info.rv2j.beans.User;

public class UserDaoImpl implements UserDao {
	private DAOFactory daoFactory;
	
	public UserDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public User find(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void create(User user) throws IllegalArgumentException, DAOException {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Initialise la requête préparée basée sur la connexion passée en argument,
	 * avec la requête SQL et les objets donnés.
	 */
	public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
		for ( int i = 0; i < objets.length; i++ ) {
			preparedStatement.setObject( i + 1, objets[i] );
		}
		return preparedStatement;
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static User map(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setID(resultSet.getInt("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("pw"));
		user.setEmail(resultSet.getString("email"));
		user.setInscriptionDate(resultSet.getDate("date_inscription"));
		return user;
	}
}
