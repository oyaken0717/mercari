package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

/**
 * Itemsテーブルの情報を取得するレポジトリ.
 * 
 * @author oyamadakenji
 *
 */
@Repository
public class ItemRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template; 
	
	public static final RowMapper<Item> ITEM_ROW_MAPPER = (rs,i) -> {
		Item item = new Item();
		item.setId(rs.getInt("i.id"));
		item.setName(rs.getString("i.name"));
		item.setCondition(rs.getInt("i.condition"));
		item.setCategory(rs.getInt("i.category"));
		item.setCategoryName(rs.getString("c.name_all"));
		item.setBrand(rs.getString("i.brand"));
		item.setPrice(rs.getDouble("i.price"));
		item.setShipping(rs.getInt("i.shipping"));
		item.setDescription(rs.getString("i.description"));
		return item;
	};
	
	/**
	 * 商品情報を全件取得する.
	 * 
	 * @return 全部のItem情報が入ったリスト
	 */
	public List<Item> findAll() {
		String sql = "SELECT i.id, i.name, i.condition, i.category, i.brand, i.price, i.shipping, i.description, c.id, c.parent, c.name, c.name_all FROM items i JOIN category c ON i.category =  c.id ORDER BY i.id LIMIT 20";
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
		return itemList;
	}
}
