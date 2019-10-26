package org.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "users")
@Component
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
    private long id;
    
    private String login;

    private String password;

    private  String salt;

    public User() {
    	
    }
    
	public User(String login, String password) {
		
		this.login = login;
		this.password = password;
	}

	public long getId() {
		return id;
	}
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
    public String toString() {
		return "models.User{" +
                "\n  id_user=" + id +
                ",\n  login='" + login + '\'' +
                ",\n   password=" + password +
				",\n   salt=" + salt +

                '}';
    	
    }
}
