package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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
public class CategorySearchRepository {

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
	 * 親カテゴリーを取得する.
	 * 
	 * @return 親カテゴリーのみ入ったリスト
	 */
	public List<Category> findAllParent() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" id, parent, name, name_all ");
		sql.append("FROM category ");
		sql.append("WHERE ");
		sql.append("parent IS null ");
		sql.append("AND ");
		sql.append("name_all IS null");
		List<Category> parentList = template.query(sql.toString(), CATEGORY_ROW_MAPPER);
		return parentList;

	}

	/**
	 * idからcategoryテーブルのレコードを取得する.
	 * 
	 * @param id id
	 * @return categoryの情報の入ったオブジェクト
	 */
	public Category load(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" id, parent, name, name_all ");
		sql.append("FROM ");
		sql.append(" category ");
		sql.append("WHERE");
		sql.append(" id = :id");
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Category category = template.queryForObject(sql.toString(), param, CATEGORY_ROW_MAPPER);
		return category;
	}

	/**
	 * 子カテゴリーを取得する.
	 * 
	 * @param parentId 親のID
	 * @return 子カテゴリーのみ入ったリスト
	 */
	public List<Category> findByParentId(Integer parentId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" id, parent, name, name_all ");
		sql.append("FROM ");
		sql.append(" category ");
		sql.append("WHERE");
		sql.append(" parent = :id");
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", parentId);
		List<Category> childList = template.query(sql.toString(), param, CATEGORY_ROW_MAPPER);
		return childList;
	}

	/**
	 * 孫カテゴリーを取得する.
	 * 
	 * @param childId 子のID
	 * @return 孫カテゴリーのみ入ったリスト
	 */
	public List<Category> findByChildId(Integer childId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" id, parent, name, name_all ");
		sql.append("FROM ");
		sql.append(" category ");
		sql.append("WHERE");
		sql.append(" parent = :id ");
		sql.append("AND");
		sql.append(" name_all IS NOT null");
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", childId);
		List<Category> grandChildList = template.query(sql.toString(), param, CATEGORY_ROW_MAPPER);
		return grandChildList;
	}
}
