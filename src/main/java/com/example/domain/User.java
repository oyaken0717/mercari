package com.example.domain;

/**
 * ユーザーの情報を登録するドメイン.
 * 
 * @author oyamadakenji
 *
 */
public class User {
	
	/** id */
	public Integer id;
	/** 名前 */	
	public String name;	
	/** メールアドレス */	
	public String email;
	/** パスワード */		
	public String password;
	/** 管理者権限 */			
	public Boolean admin;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", admin=" + admin
				+ "]";
	}
}
