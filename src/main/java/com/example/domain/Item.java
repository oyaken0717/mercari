package com.example.domain;

/**
 * 商品情報を保持するドメイン.
 * 
 * @author oyamadakenji
 *
 */
public class Item {

	/** ID */
	private Integer id;
	/** 商品名 */
	private String name;
	/** ??? */
	private Integer condition;
	/** 「/」区切りのカテゴリー */
	private Integer category;
	/** ブランド */
	private String brand;
	/** 価格 */
	private double price;
	/** 配送? */
	private Integer shipping;
	/** 商品説明 */
	private String description;
	
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
	public Integer getCondition() {
		return condition;
	}
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getShipping() {
		return shipping;
	}
	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", condition=" + condition + ", category=" + category + ", brand="
				+ brand + ", price=" + price + ", shipping=" + shipping + ", description=" + description + "]";
	}
}