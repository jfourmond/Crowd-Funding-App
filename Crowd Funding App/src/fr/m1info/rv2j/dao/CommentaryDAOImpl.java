package fr.m1info.rv2j.dao;

import static fr.m1info.rv2j.dao.DAOUtility.initialisationPreparedRequest;
import static fr.m1info.rv2j.dao.DAOUtility.silentCloses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.m1info.rv2j.beans.Commentary;

public class CommentaryDAOImpl implements CommentaryDAO {
	/**	Structure la table		**/
	/**		id INT(10) 			**/
	/**		author_id INT(10)	**/
	/**		project_id INT(10)	**/
	/**		text VARCHAR(140) 	**/
	/**		creation_date DATE	**/
	/**		last_update DATE 	**/
	
	private DAOFactory daoFactory;
	
	private static final String ID = "id";
	private static final String AUTHOR_ID = "author_id";
	private static final String PROJECT_ID = "project_id";
	private static final String TEXT = "text";
	private static final String CREATION_DATE = "creation_date";
	private static final String LAST_UPDATE = "last_update";
	
	private static final String SELECT_BY_ID = "SELECT id, author_id, project_id, text, creation_date, last_update FROM commentaries where id = ? ";
	private static final String SELECT_BY_AUTHOR_ID = "SELECT id, author_id, project_id, text, creation_date, last_update FROM commentaries where project_id = ? ";
	
	private static final String SELECT_ALL = "SELECT * FROM commentaries";
	
	private static final String INSERT = "INSERT INTO commentaries(author_id, project_id, text, creation_date, last_update) VALUES (?, ?, ?, ?, ?)";
	
	private static final String UPDATE = "UPDATE commentaries SET text = ?, last_update = NOW() WHERE id = ?";
	
	private static final String DELETE = "DELETE FROM commentaries WHERE id = ? ";
	
	private static final String COUNT = "SELECT COUNT(*) FROM commentaries";
	
	public CommentaryDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(Commentary commentary) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet values = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, INSERT, true, commentary.getAuthorID(), commentary.getProjectID(), commentary.getText(), commentary.getCreationDate(), commentary.getLastUpdate());
			int status = preparedStatement.executeUpdate();
			if(status == 0)
				throw new DAOException("Échec de la création du commentaire, aucune ligne ajoutée dans la table.");
			values = preparedStatement.getGeneratedKeys();
			if(values.next())
				commentary.setID(values.getInt(1));
			else
				throw new DAOException("Échec de la création du commentaire en base, aucun ID auto-généré retourné.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}

	@Override
	public void update(String id, Commentary commentary) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet values = null;
		
		try {
			connection = daoFactory.getConnection();	
			preparedStatement = initialisationPreparedRequest(connection, UPDATE, false, commentary.getText(), commentary.getLastUpdate(), id);
			int status = preparedStatement.executeUpdate();
			if(status == 0)
				throw new DAOException("Échec de l'édition du commentaire, aucune ligne éditée dans la table.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}

	@Override
	public Commentary findByID(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Commentary commentary = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_ID, false, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				commentary = map(resultSet);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return commentary;
	}

	@Override
	public List<Commentary> findByProjectID(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Commentary> commentaries = new ArrayList<Commentary>();
		Commentary commentary = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_AUTHOR_ID, false, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				commentary = map(resultSet);
				commentaries.add(commentary);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return commentaries;
	}
	
	@Override
	public List<Commentary> getAllCommentary() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Commentary> commentaries = new ArrayList<Commentary>();
		Commentary commentary = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_ALL, false);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				commentary = map(resultSet);
				commentaries.add(commentary);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return commentaries;
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
				throw new DAOException("Échec de la suppresion du commentaire, aucune ligne supprimée dans la table.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}

	@Override
	public int count() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		int count = 0;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, COUNT, true);
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			count = resultSet.getInt(1);
			System.out.println(count);
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return count;
	}
	
	private static Commentary map(ResultSet resultSet) throws SQLException {
		Commentary commentary = new Commentary();
		commentary.setID(resultSet.getInt(ID));
		commentary.setAuthorID(resultSet.getInt(AUTHOR_ID));
		commentary.setProjectID(resultSet.getInt(PROJECT_ID));
		commentary.setText(resultSet.getString(TEXT));
		commentary.setCreationDate(resultSet.getDate(CREATION_DATE));
		commentary.setLastUpdate(resultSet.getDate(LAST_UPDATE));
		return commentary;
	}

}
