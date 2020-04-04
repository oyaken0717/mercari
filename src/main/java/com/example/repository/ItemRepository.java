package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

	public static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
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
	 * 商品情報を全件取得する.
	 * 
	 * @return 全部のItem情報が入ったリスト
	 */
	public List<Item> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" i.id AS i_id, i.name AS i_name, i.condition AS i_condition, i.category AS i_category,");
		sql.append(
				" i.brand AS i_brand, i.price AS i_price, i.shipping AS i_shipping, i.description AS i_description,");
		sql.append(" c.id AS c_id, c.parent AS c_parent, c.name AS c_name, c.name_all AS c_name_all ");
		sql.append("FROM items i JOIN category c ");
		sql.append("ON i.category =  c.id ");
		sql.append("ORDER BY i.id ");
		sql.append("LIMIT 20");
		List<Item> itemList = template.query(sql.toString(), ITEM_ROW_MAPPER);
		return itemList;
	}

//	public List<Item> findAll() {
//		String sql = "SELECT i.id AS i_id, i.name AS i_name, i.condition AS i_condition, i.category AS i_category, i.brand AS i_brand, i.price AS i_price, i.shipping AS i_shipping, i.description AS i_description, c.id AS c_id, c.parent AS c_parent, c.name AS c_name, c.name_all AS c_name_all FROM items i JOIN category c ON i.category =  c.id ORDER BY i.id LIMIT 20";
//		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
//		return itemList;
//	}

	/**
	 * idで指定された商品情報を取得する.
	 * 
	 * @return Item情報が入ったリスト
	 */
	public Item load(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" i.id AS i_id, i.name AS i_name, i.condition AS i_condition, i.category AS i_category,");
		sql.append(
				" i.brand AS i_brand, i.price AS i_price, i.shipping AS i_shipping, i.description AS i_description,");
		sql.append(" c.id AS c_id, c.parent AS c_parent, c.name AS c_name, c.name_all AS c_name_all ");
		sql.append("FROM items i JOIN category c ");
		sql.append("ON i.category =  c.id ");
		sql.append("WHERE i.id = :id");
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Item item = template.queryForObject(sql.toString(), param, ITEM_ROW_MAPPER);
		return item;
	}

	public void save(Item item) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(item);
        StringBuilder sql = new StringBuilder();
        if (item.getId() == null) {
//                String insertSql = "INSERT INTO employees (name,age,gender,development_id) VALUES (:name,:age,:gender,:developmentId)";
//                template.update(insertSql,param);
        }else {    		
        	sql.append("UPDATE");
        	sql.append(" items ");
        	sql.append("SET");
        	sql.append(" name = :name, price = :price, category = :category, brand = :brand, condition = :condition, description = :description ");
        	sql.append("WHERE");
        	sql.append(" id = :id");
            template.update(sql.toString(), param);                        
        }
	}
}
