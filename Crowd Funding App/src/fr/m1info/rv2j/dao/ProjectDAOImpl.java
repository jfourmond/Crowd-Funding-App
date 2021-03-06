package fr.m1info.rv2j.dao;

import static fr.m1info.rv2j.dao.DAOUtility.initialisationPreparedRequest;
import static fr.m1info.rv2j.dao.DAOUtility.silentCloses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.m1info.rv2j.beans.Project;

public class ProjectDAOImpl implements ProjectDAO {
	/** Structure de la table		**/
	/**		id INT(10)				**/
	/**		author_id INT(10)		**/
	/**		name TEXT				**/
	/**		presentation LONGTEXT	**/
	/**		goal INT(10)			**/
	/**		picture_path LONGTEXT	**/
	/**		creation_date DATE		**/
	/**		last_update DATE		**/
	
	private DAOFactory daoFactory;
	
	private static final String ID = "id";
	private static final String AUTHOR_ID = "author_id";
	private static final String NAME = "name";
	private static final String PRESENTATION = "presentation";
	private static final String GOAL = "goal";
	private static final String CREATION_DATE = "creation_date";
	private static final String LAST_UPDATE = "last_update";
	
	private static final String SELECT_BY_ID = "SELECT id,  name, author_id, presentation, goal, creation_date, last_update FROM projects where id = ? ";

	private static final String SELECT_BY_NAME = "SELECT id, name, author_id, presentation, goal, creation_date, last_update FROM projects where name = ? ";

	private static final String SELECT_BY_AUTHOR_ID = "SELECT id, name, author_id, presentation, goal, creation_date, last_update FROM projects where author_id = ? ";

	private static final String SELECT_ALL = "SELECT * FROM projects";
	
	private static final String INSERT = "INSERT INTO projects(name, author_id, presentation, goal, creation_date, last_update) VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String UPDATE = "UPDATE projects SET name = ?, presentation = ?, goal = ?, last_update = ? WHERE id = ?";
	
	private static final String DELETE = "DELETE FROM projects WHERE id = ? ";
	
	private static final String COUNT = "SELECT COUNT(*) FROM projects";
	
	public ProjectDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(Project project) throws IllegalArgumentException, DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet values = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, INSERT, true, project.getName(), project.getAuthorID(), project.getPresentation(), project.getGoal(), project.getCreationDate(), project.getLastUpdateDate());
			int status = preparedStatement.executeUpdate();
			if(status == 0)
				throw new DAOException("Échec de la création de projet, aucune ligne ajoutée dans la table.");
			values = preparedStatement.getGeneratedKeys();
			if(values.next())
				project.setID(values.getInt(1));
			else
				throw new DAOException("Échec de la création du projet, aucun ID auto-généré retourné.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}
	
	@Override
	public void update(String id, Project project) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet values = null;
		
		try {
			connection = daoFactory.getConnection();	
			preparedStatement = initialisationPreparedRequest(connection, UPDATE, false, project.getName(), project.getPresentation(), project.getGoal(), project.getLastUpdateDate(), id);
			int status = preparedStatement.executeUpdate();
			if(status == 0)
				throw new DAOException("Échec de l'édition du projet, aucune ligne éditée dans la table.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}
	
	@Override
	public Project findByID(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Project project = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_ID, false, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				project = map(resultSet);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return project;
	}
	
	@Override
	public Project findByName(String name) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Project project = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_NAME, false, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				project = map(resultSet);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return project;
	}
	
	public List<Project> findByAuthorID(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Project> projects = new ArrayList<Project>();
		Project project = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_AUTHOR_ID, false, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				project = map(resultSet);
				projects.add(project);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return projects;
	}
	
	@Override
	public List<Project> getAllProjects() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Project> projects = new ArrayList<Project>();
		Project project = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_ALL, false);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				project = map(resultSet);
				projects.add(project);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return projects;
	}
	
	@Override
	public Map<Integer, Project> mapProjects() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Map<Integer, Project> projects = new HashMap<Integer, Project>();
		Project project = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_ALL, false);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				project = map(resultSet);
				projects.put(project.getID(), project);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return projects;
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
				throw new DAOException("Échec de la suppresion du projet, aucune ligne supprimée dans la table.");
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
	
	private static Project map(ResultSet resultSet) throws SQLException {
		Project project = new Project();
		project.setID(resultSet.getInt(ID));
		project.setAuthorID(resultSet.getInt(AUTHOR_ID));
		project.setName(resultSet.getString(NAME));
		project.setPresentation(resultSet.getString(PRESENTATION));
		project.setGoal(resultSet.getInt(GOAL));
		project.setCreationDate(resultSet.getDate(CREATION_DATE));
		project.setLastUpdateDate(resultSet.getDate(LAST_UPDATE));
		return project;
	}
}
