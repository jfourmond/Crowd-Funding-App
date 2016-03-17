package fr.m1info.rv2j.dao.implementations;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.exceptions.DAOException;
import fr.m1info.rv2j.dao.interfaces.UserDao;

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
}
