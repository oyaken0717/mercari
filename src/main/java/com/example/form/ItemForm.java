package com.example.form;

public class ItemForm {

	//■Integer型 ■1.id,■2.condition,■3.category,■4.price,■5.shipping
	/** ID */
	private String id;
	/** 商品名 */
	private String name;
	/** ??? */
	private String condition;
	/** 小のid */
	private String category;
	/** 「/」区切りのカテゴリーネーム */
	private String categoryName;	
	/** ブランド */
	private String brand;
	/** 価格 */
	private String price;
	/** 配送? */
	private String shipping;
	/** 商品説明 */
	private String description;

//■Integer型 ■1.id,■2.condition,■3.category,■4.price,■5.shipping

	public Integer getIntId() {
		return Integer.parseInt(id);
	}
	public Integer getIntCondition() {
		return Integer.parseInt(condition);
	}
	public Integer getIntCategory() {
		return Integer.parseInt(category);
	}
	public Integer getIntPrice() {
		return Integer.parseInt(price);
	}
	public Integer getIntShipping() {
		return Integer.parseInt(shipping);
	}
//------------------------------------------
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
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
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
		return "ItemForm [id=" + id + ", name=" + name + ", condition=" + condition + ", category=" + category
				+ ", categoryName=" + categoryName + ", brand=" + brand + ", price=" + price + ", shipping=" + shipping
				+ ", description=" + description + "]";
	}
}
