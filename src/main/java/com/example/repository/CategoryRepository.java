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

	public void insert(Category category) {
		StringBuilder sql = new StringBuilder();
		SqlParameterSource param = new BeanPropertySqlParameterSource(category);
		sql.append("INSERT INTO ");
		sql.append(" category ");
		sql.append(" (parent, name, name_all) ");
		sql.append("VALUES ");
		sql.append(" (:parent, :name, :nameAll)");
		template.update(sql.toString(), param);
	}
}
