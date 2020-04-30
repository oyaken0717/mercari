package com.example.form;

/**
 * User情報をformから取得するフォーム.
 * 
 * @author oyamadakenji
 *
 */
public class UserForm {

	/** ■id */
	public String id;
	/** 名前 */	
	public String name;	
	/** メールアドレス */	
	public String email;
	/** パスワード */		
	public String password;
	/** ■管理者権限 */			
	public String admin;
	
	public Integer getIntId() {
		return Integer.parseInt(id);
	}
	public Boolean getBooleanAdmin() {
		return Boolean.valueOf(admin);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserForm [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", admin="
				+ admin + "]";
	}
}
