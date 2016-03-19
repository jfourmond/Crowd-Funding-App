package fr.m1info.rv2j.dao;

import fr.m1info.rv2j.beans.User;

public interface UserDao {
	void create(User user) throws DAOException;
	
	User find(String email) throws DAOException;
}
