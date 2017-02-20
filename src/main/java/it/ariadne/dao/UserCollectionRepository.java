package it.ariadne.dao;

import java.util.ArrayList;
import java.util.List;

import it.ariadne.model.User;
import it.ariadne.model.UserRepository;

public class UserCollectionRepository implements UserRepository {

	private List<User> userList = new ArrayList<User>();
	private static long i = 0L;
	
	@Override
	public User saveUser(User user) {
		user.setId(i++);
		userList.add(user);
		return user;
	}

	@Override
	public User findByUsername(String username) {
		
		User retrivedUser = null;
		
		for (User user : userList) {
			if(user.getUsername().equals(username)){
				retrivedUser = user;
				break;
			}
		}
		return retrivedUser;
	}
	
	

}
