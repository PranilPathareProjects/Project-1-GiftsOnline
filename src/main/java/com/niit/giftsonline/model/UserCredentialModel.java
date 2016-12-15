package com.niit.giftsonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.niit.giftsonline.daoimpl.UserCredentialDAOImpl;

@Entity
@Table(name="User_Credentials")
@Component
public class UserCredentialModel
{	
	@Id
	@Column(name="username")
	private String userName;
	
	@NotEmpty
	@Column(name="password")
	private String password;
	
	private boolean enabled;
	
	@NotEmpty
	@Column(name="role")
	private String role;
	
	public UserCredentialModel() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}