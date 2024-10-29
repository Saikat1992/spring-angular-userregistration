package com.javatechie.dto;

public class UserInfo {
	
	private int id;
	private String name;
	private String email;
	private String domain;
	private int experience;
	private String token;
	
	public UserInfo(int id, String name, String email, String domain, int experience, String token) {
		super();
		this.id = id;
		this.name= name;
		this.email = email;
		this.domain = domain;
		this.experience = experience;
		this.token = token;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public UserInfo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
