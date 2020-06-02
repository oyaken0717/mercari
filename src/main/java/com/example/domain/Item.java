package com.example.domain;

import java.util.List;

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
	/** 価格 */
	private double price;
	/** 小のid */
	private Integer category;

	/** 「/」区切りのカテゴリーネーム */
	private String categoryName;	

	/** ブランド */
	private String brand;
	/** ??? */
	private Integer condition;
	/** 商品説明 */
	private String description;

	/** 配送? */
	private Integer shipping;
		
	/** 画像 */
	private String image;
	
	/** saleドメイン(1つしか入らないけど) */
	private List<Sale> saleList;

	/** Sale期間かどうか */
	private boolean set;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getCondition() {
		return condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getShipping() {
		return shipping;
	}

	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Sale> getSaleList() {
		return saleList;
	}

	public void setSaleList(List<Sale> saleList) {
		this.saleList = saleList;
	}

	public boolean isSet() {
		return set;
	}

	public void setSet(boolean set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", categoryName="
				+ categoryName + ", brand=" + brand + ", condition=" + condition + ", description=" + description
				+ ", shipping=" + shipping + ", image=" + image + ", saleList=" + saleList + ", set=" + set + "]";
	}
	
}
