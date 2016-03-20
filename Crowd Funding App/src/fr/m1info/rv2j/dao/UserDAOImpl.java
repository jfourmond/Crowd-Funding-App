package fr.m1info.rv2j.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static fr.m1info.rv2j.dao.DAOUtility.*;

import fr.m1info.rv2j.beans.User;

public class UserDAOImpl implements UserDAO {
	private DAOFactory daoFactory;
	
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String PW = "pw";
	private static final String EMAIL = "email";
	private static final String INSCRIPTION_DATE = "inscription_date";
	private static final String RIGHT_LEVEL = "right_level";
	
	private static final String SELECT_BY_ID = "SELECT id, name, pw, email, inscription_date, right_level FROM users where id = ? ";
	private static final String SELECT_BY_NAME = "SELECT id, name, pw, email, inscription_date, right_level FROM users where name = ? ";
	private static final String SELECT_BY_EMAIL = "SELECT id, name, pw, email, inscription_date, right_level FROM users where email = ? ";
	
	private static final String SELECT_ALL = "SELECT * FROM users";
	
	private static final String INSERT = "INSERT INTO users(name, pw, email, inscription_date, right_level) VALUES (?, ?, ?, ?, ?)";
	
	private static final String UPDATE = "UPDATE users SET name = ?, pw = ?, email = ?, right_level = ? WHERE id = ?";
	
	private static final String DELETE = "DELETE FROM users WHERE id = ? ";
	
	public UserDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(User user) throws IllegalArgumentException, DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet values = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, INSERT, true, user.getName(), user.getPassword(), user.getEmail(), user.getInscriptionDate(), user.getRightLevel());
			int status = preparedStatement.executeUpdate();
			if(status == 0)
				throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
			values = preparedStatement.getGeneratedKeys();
			if(values.next())
				user.setID(values.getInt(1));
			else
				throw new DAOException("Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}
	
	@Override
	public void update(String id, User user) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet values = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, UPDATE, false, user.getName(), user.getPassword(), user.getEmail(), user.getRightLevel(), id);
			int status = preparedStatement.executeUpdate();
			if(status == 0)
				throw new DAOException("Échec de l'édition de l'utilisateur, aucune ligne éditée dans la table.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}
	
	@Override
	public User findByID(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_ID, false, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = map(resultSet);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return user;
	}
	
	@Override
	public User findByName(String name) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_NAME, false, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = map(resultSet);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return user;
	}
	
	@Override
	public User findByEmail(String email) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_EMAIL, false, email);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = map(resultSet);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return user;
	}

	
	@Override
	public List<User> getAllUsers() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<User> users = new ArrayList<User>();
		User user = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_ALL, false);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = map(resultSet);
				users.add(user);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return users;
	}
	
	@Override
	public void deleteByID(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet values = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, DELETE, false, id);
			int status = preparedStatement.executeUpdate();
			if(status == 0)
				throw new DAOException("Échec de la suppresion de l'utilisateur, aucune ligne supprimée dans la table.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}
	
	private static User map(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setID(resultSet.getInt(ID));
		user.setName(resultSet.getString(NAME));
		user.setPassword(resultSet.getString(PW));
		user.setEmail(resultSet.getString(EMAIL));
		user.setInscriptionDate(resultSet.getDate(INSCRIPTION_DATE));
		user.setRightLevel(resultSet.getInt(RIGHT_LEVEL));
		return user;
	}
}
