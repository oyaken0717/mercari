package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

@Repository
public class ItemSearchRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setCondition(rs.getInt("condition"));
		item.setCategory(rs.getInt("category"));
		item.setBrand(rs.getString("brand"));
		item.setPrice(rs.getDouble("price"));
		item.setShipping(rs.getInt("shipping"));
		item.setDescription(rs.getString("description"));
		return item;
	};

	public static final RowMapper<Item> ITEM_ROW_MAPPER2 = (rs, i) -> {
		Item item = new Item();
		item.setId(rs.getInt("i_id"));
		item.setName(rs.getString("i_name"));
		item.setCondition(rs.getInt("i_condition"));
		item.setCategory(rs.getInt("i_category"));
		item.setCategoryName(rs.getString("c_name_all"));
		item.setBrand(rs.getString("i_brand"));
		item.setPrice(rs.getDouble("i_price"));
		item.setShipping(rs.getInt("i_shipping"));
		item.setDescription(rs.getString("i_description"));
		return item;
	};

	/**
	 * nameからitemのレコードを取得する.
	 * 
	 * @param name 商品名
	 * @return itemの情報が入ったオブジェクト
	 */
	public Item findByName(String name) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" id, name, condition, category, brand, price, shipping, description ");
		sql.append("FROM ");
		sql.append(" items ");
		sql.append("WHERE");
		sql.append(" name = :name");
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
		List<Item> itemList = template.query(sql.toString(), param, ITEM_ROW_MAPPER);
		if (itemList.size() == 0) {
			return null;
		}
		return itemList.get(0);
	}

	/**
	 * brandからitemのレコードを取得する.
	 * 
	 * @param brand ブランド名
	 * @return itemの情報が入ったオブジェクト
	 */
	public Item findByBrand(String brand) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" id, name, condition, category, brand, price, shipping, description ");
		sql.append("FROM ");
		sql.append(" items ");
		sql.append("WHERE");
		sql.append(" brand = :brand");
		SqlParameterSource param = new MapSqlParameterSource().addValue("brand", brand);
		List<Item> itemList = template.query(sql.toString(), param, ITEM_ROW_MAPPER);
		if (itemList.size() == 0) {
			return null;
		}
		return itemList.get(0);
	}

	public List<Item> findByKeyWords(String name, String nameAll, String brand) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" i.id AS i_id, i.name AS i_name, i.condition AS i_condition, i.category AS i_category,");
		sql.append(" i.brand AS i_brand, i.price AS i_price, i.shipping AS i_shipping, i.description AS i_description,");
		sql.append(" c.id AS c_id, c.parent AS c_parent, c.name AS c_name, c.name_all AS c_name_all ");
		sql.append("FROM");
		sql.append(" items i ");
		sql.append("JOIN");
		sql.append(" category c ");
		sql.append("ON");
		sql.append(" i.category =  c.id ");
		sql.append("WHERE");
		sql.append(" i.name LIKE :name ");
		sql.append("AND");
		sql.append(" c.name_all LIKE :name_all ");
		sql.append("AND");
		sql.append(" i.brand LIKE :brand ");
		sql.append("ORDER BY i.id ");
		sql.append("LIMIT 20 ");
		sql.append("OFFSET 0");
		
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", "%" + name + "%")
				.addValue("name_all", nameAll + "%")
				.addValue("brand", "%" + brand + "%");
		List<Item> itemList = template.query(sql.toString(), param, ITEM_ROW_MAPPER2);
		System.out.println(itemList);
		if (itemList.size() == 0) {
			return null;
		}
		
		return itemList;
	}
}
