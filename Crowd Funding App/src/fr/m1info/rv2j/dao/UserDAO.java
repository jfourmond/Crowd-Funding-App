package fr.m1info.rv2j.dao;

import java.util.List;

import fr.m1info.rv2j.beans.User;

public interface UserDAO {
	void create(User user) throws DAOException;
	
	void update(String id, User user) throws DAOException;
	
	User findByID(String id) throws DAOException;
	
	User findByName(String name) throws DAOException;
	
	User findByEmail(String email) throws DAOException;
	
	List<User> getAllUsers() throws DAOException;
	
	void deleteByID(String id) throws DAOException;
}
