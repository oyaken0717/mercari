package com.example.form;

/**
 * 入力フォームから受け取った値が格納される.
 * 
 * @author oyamadakenji
 *
 */
public class SaleForm {
	
	/** id */
	private String id;	
	/** itemのid */
	private String itemId;
	/** 価格 */	
	private String price;
	/** セール期間の締切年 */	
	private String year;
	/** セール期間の締切月 */	
	private String month;
	/** セール期間の締切日 */	
	private String day;
	
	public Integer getIntId() {
		return Integer.parseInt(id);
	}
	public Integer getIntItemId() {
		return Integer.parseInt(itemId);
	}
	public Double getDoublePrice() {
		return Double.parseDouble(price);
	}
	
//■ ーーーーーーーーーーーーーーーーーーーーーーーー	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "SaleForm [id=" + id + ", itemId=" + itemId + ", price=" + price + ", year=" + year + ", month=" + month
				+ ", day=" + day + "]";
	}
}
