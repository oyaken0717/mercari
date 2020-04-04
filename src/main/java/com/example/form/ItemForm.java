package com.example.form;

/**
 * 商品登録画面と編集画面で入力された情報を格納するドメイン.
 * 
 * @author oyamadakenji
 *
 */
public class ItemForm {

	//■Integer型 ■1.id,■2.condition,■3.category,■4.price,■5.shipping
	/** 商品ID(hidden) */
	private String id;
	/** 商品名 */
	private String name;
	/** 価格 */
	private String price;

	/** 小のid(category_id) */
	private String category;
	
	/** ブランド */
	private String brand;
	/** コンディション */
	private String condition;
	/** 商品説明 */
	private String description;	

//■ getInt系 -------------------------------
	public Integer getIntId() {
		if (id!=null) {
			return Integer.parseInt(id);			
		}
		return null;
	}
	public Double getDoublePrice() {
		return Double.parseDouble(price);
	}
	public Integer getIntCategory() {
		return Integer.parseInt(category);
	}
	public Integer getIntCondition() {
		return Integer.parseInt(condition);
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ItemForm [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", brand="
				+ brand + ", condition=" + condition + ", description=" + description + "]";
	}
}
