package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;

/**
 * 大中小のカテゴリーの情報を取得するレポジトリー.
 * 
 * @author oyamadakenji
 *
 */
@Repository
public class CategoryRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<Category> CATEGORY_ROW_MAPPER = (rs, i) -> {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setParent(rs.getInt("parent"));
		category.setName(rs.getString("name"));
		category.setNameAll(rs.getString("name_all"));
		return category;
	};

	/**
	 * 新しいカテゴリー情報を登録、更新する.
	 * 
	 * @param category 登録、編集したいカテゴリー情報
	 */
	public void insert(Category category) {
		StringBuilder sql = new StringBuilder();
		if (category.getId()==null) {
			SqlParameterSource param = new BeanPropertySqlParameterSource(category);
			sql.append("INSERT INTO ");
			sql.append(" category ");
			sql.append(" (parent, name, name_all) ");
			sql.append("VALUES ");
			sql.append(" (:parent, :name, :nameAll)");
			template.update(sql.toString(), param);			
		}else {
			SqlParameterSource param = new MapSqlParameterSource().addValue("name", category.getName()).addValue("id", category.getId());
			sql.append("UPDATE ");
			sql.append(" category ");
			sql.append("SET ");
			sql.append(" name = :name ");
			sql.append("WHERE ");
			sql.append(" id = :id ");
			template.update(sql.toString(), param);
		}
	}
	
	/**
	 * 1つのカテゴリー情報を取得する.
	 * 
	 * @param id 取得したいカテゴリーのid
	 * @return 1つのカテゴリー情報
	 */
	public Category load(Integer id) {
		StringBuilder sql = new StringBuilder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		sql.append("SELECT ");
		sql.append(" id, parent, name, name_all ");
		sql.append("FROM ");
		sql.append(" category ");
		sql.append("WHERE ");
		sql.append(" id = :id ");
		Category category = template.queryForObject(sql.toString(), param, CATEGORY_ROW_MAPPER);
		return category;
	}
	
	/**
	 * カテゴリー情報を削除する. 
	 * 
	 * @param id カテゴリーのid
	 */
	public void delete(Integer id) {
		StringBuilder sql = new StringBuilder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		sql.append("DELETE ");
		sql.append("FROM ");
		sql.append(" category ");
		sql.append("WHERE ");
		sql.append(" id = :id ");
		template.update(sql.toString(), param);
		
	}
}
