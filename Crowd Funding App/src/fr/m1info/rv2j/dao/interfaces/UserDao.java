package fr.m1info.rv2j.dao.interfaces;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.exceptions.DAOException;

public interface UserDao {
	void create(User user) throws DAOException;
	
	User find(String email) throws DAOException;
}
