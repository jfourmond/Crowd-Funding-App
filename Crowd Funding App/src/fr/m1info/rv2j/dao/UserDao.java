package fr.m1info.rv2j.dao;

import fr.m1info.rv2j.beans.User;

public interface UserDao {
	void create(User user) throws DAOException;
	
	User findByName(String name) throws DAOException;
	
	User findByEmail(String email) throws DAOException;
}
