package com.gcy.offsitelanding_server;

public class User {
	private String username;
	private String password;
	private String registrationId;//用户登录的设备（在jpush上的注册ID）
	private int status;//登录状态，0-离线 1-在线
	
	public User() {
		super();
	}
	public User(String username, String password, int status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	
	
	
}
