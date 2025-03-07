package com.javatechie.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(schema = "demo", name="user_reg_tbl")
public class Users {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable=false)
	private int id;
	
	@Column(name="domain", nullable=false)
	private String domain;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="experience", nullable=false)
	private String experience;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="password", nullable=false)
	private String password;
	
	/*
	 * public Users(String domain, String email, String experience, String name) {
	 * //this.id= id; this.domain= domain; this.email= email; this.experience=
	 * experience; this.name= name; }
	 */
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Users(int id,String domain, String email, String experience, String name, String password) {
		this.id= id;
		this.domain= domain;
		this.email= email;
		this.experience= experience;
		this.name= name;
		this.password= password;
	}
	
	public Users(){
		
	}
	
	
	

	

	@Override
	public String toString() {
		return "Users [id=" + id + ", domain=" + domain + ", email=" + email + ", experience=" + experience + ", name="
				+ name + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
