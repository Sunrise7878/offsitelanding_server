package com.gcy.offsitelanding_server;

public class User {
	private String username;
	private String password;
	private String registrationId;//�û���¼���豸����jpush�ϵ�ע��ID��
	private int status;//��¼״̬��0-���� 1-����
	
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
