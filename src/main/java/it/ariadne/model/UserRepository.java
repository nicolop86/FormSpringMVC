package it.ariadne.model;

public interface UserRepository {
	
	public User saveUser(User user);

	public User findByUsername(String username);
}