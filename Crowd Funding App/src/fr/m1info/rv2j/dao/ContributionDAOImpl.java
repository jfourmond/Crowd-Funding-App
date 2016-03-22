package fr.m1info.rv2j.dao;

import static fr.m1info.rv2j.dao.DAOUtility.initialisationPreparedRequest;
import static fr.m1info.rv2j.dao.DAOUtility.silentCloses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.m1info.rv2j.beans.Contribution;

public class ContributionDAOImpl implements ContributionDAO {
	private DAOFactory daoFactory;
	
	private static final String AUTHOR_ID = "contributor_id";
	private static final String PROJECT_ID = "project_id";
	private static final String COMPENSATION_id = "compensation_id";
	private static final String DONATION = "donation";
	private static final String CREATION_DATE = "creation_date";
	
	private static final String SELECT_ALL = "SELECT * FROM contributions";
	private static final String SELECT_BY_AUTHOR_ID = "SELECT contributor_id, project_id, donation, creation_date FROM contributions WHERE author_id = ?";
	private static final String SELECT_BY_PROJECT_ID = "SELECT contributor_id, project_id, donation, creation_date FROM contributions WHERE project_id = ?";
	
	private static final String INSERT = "INSERT INTO contributions(contributor_id, project_id, donation, creation_date) VALUES (?, ?, ?, ?)";
	
	private static final String SUM_BY_PROJECT_ID = "SELECT SUM(donation) FROM contributions WHERE project_id = ?";
	
	public ContributionDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(Contribution contribution) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet values = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, INSERT, false, contribution.getUserID(), contribution.getProjectID(), contribution.getDonation(), contribution.getCreationDate());
			int status = preparedStatement.executeUpdate();
			if(status == 0)
				throw new DAOException("Échec de la création de la contribution, aucune ligne ajoutée dans la table.");
		} catch (SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(values, preparedStatement, connection);
		}
	}

	@Override
	public List<Contribution> findByAuthorID(String author_id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Contribution> contributions = new ArrayList<Contribution>();
		Contribution contribution = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_AUTHOR_ID, false, author_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				contribution = map(resultSet);
				contributions.add(contribution);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return contributions;
	}

	@Override
	public List<Contribution> findByProjectID(String project_id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Contribution> contributions = new ArrayList<Contribution>();
		Contribution contribution = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_BY_PROJECT_ID, false, project_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				contribution = map(resultSet);
				contributions.add(contribution);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return contributions;
	}
	
	@Override
	public List<Contribution> getAllContributions() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Contribution> contributions = new ArrayList<Contribution>();
		Contribution contribution = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SELECT_ALL, false);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				contribution = map(resultSet);
				contributions.add(contribution);
			}
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return contributions;
	}
	
	@Override
	public int getTotalContributionsToProject(String project_id) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		int sum = 0;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initialisationPreparedRequest(connection, SUM_BY_PROJECT_ID, true, project_id);
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			sum = resultSet.getInt(1);
		} catch(SQLException E) {
			throw new DAOException(E);
		} finally {
			silentCloses(resultSet, preparedStatement, connection);
		}
		return sum;
	}
	
	private static Contribution map(ResultSet resultSet) throws SQLException {
		Contribution contribution = new Contribution();
		
		contribution.setUserID(resultSet.getInt(AUTHOR_ID));
		contribution.setProjectID(resultSet.getInt(PROJECT_ID));
		contribution.setDonation(resultSet.getInt(DONATION));
		contribution.setCreationDate(resultSet.getDate(CREATION_DATE));
		
		return contribution;
	}
}
