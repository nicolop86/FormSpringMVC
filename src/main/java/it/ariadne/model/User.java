package it.ariadne.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;

	public User () {
		
	}
	/*This constructor will be used when the user is in the DB and to set the ID*/
	public User(long id, String firstname, String lastname, String username, String password){
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	/*This constructor will be used when the user is not in the DB*/
	public User(String firstname, String lastname, String username, String password){
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
