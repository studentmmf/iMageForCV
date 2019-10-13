package org.models;

import java.util.List;

public interface BaseDAO {

	public User findUserById(long id);
	
	
	
	public void save(User user);
	
	public String findPasswordByLogin(String login);
	
	public void updatePassword(String login, String password);

	boolean userExists(String login);



	
}
