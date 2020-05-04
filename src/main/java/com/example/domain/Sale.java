package com.example.domain;

import java.sql.Date;

/**
 * 各itemのセール情報をまとめたドメイン.
 * 
 * @author oyamadakenji
 *
 */
public class Sale {
	
	/** id */
	private Integer id;	
	/** itemのid */
	private Integer itemId;
	/** 価格 */	
	private Double price;
	/** セール期間の締切日 */	
	private Date term;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getTerm() {
		return term;
	}

	public void setTerm(Date term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", itemId=" + itemId + ", price=" + price + ", term=" + term + "]";
	}
	
}
