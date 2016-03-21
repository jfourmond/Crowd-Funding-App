package fr.m1info.rv2j.dao;

import java.util.List;
import fr.m1info.rv2j.beans.Project;

public interface ProjectDAO {
	void create(Project project) throws DAOException;
	
	void update(String id, Project project) throws DAOException;
	
	Project findByID(String id) throws DAOException;
	
	Project findByNAME(String name) throws DAOException;
	
	List<Project> getAllProjects() throws DAOException;
	
	void deleteByID(String id) throws DAOException;
}