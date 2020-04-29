package com.example.form;

/**
 * カテゴリー登録時に登録画面からデータを受け取るフォーム.
 * 
 * @author oyamadakenji
 *
 */
public class CategoryForm {

	/** id */
	private String id;
	/** 大または中のidが入る */
	private String parent;
	/** カテゴリー名 */
	private String name;
	/** 「/」区切りのカテゴリー名 */
	private String nameAll;
	
//■ ーーーーーーーーーーーーーーーーーーーーーーーーーー	
	public Integer getIntId() {
		return Integer.parseInt(id);
	}

	public Integer getIntParent() {
		return Integer.parseInt(parent);
	}
	
//■ ーーーーーーーーーーーーーーーーーーーーーーーーーー	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameAll() {
		return nameAll;
	}
	public void setNameAll(String nameAll) {
		this.nameAll = nameAll;
	}
	@Override
	public String toString() {
		return "CategoryForm [id=" + id + ", parent=" + parent + ", name=" + name + ", nameAll=" + nameAll + "]";
	}
}
