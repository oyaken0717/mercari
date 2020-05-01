package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

/**
 * User情報を取得するレポジトリ.
 * 
 * @author oyamadakenji
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public static final RowMapper<User> USER_ROW_MAPPER = (rs,i)-> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setAdmin(rs.getBoolean("admin"));
		return user;
	};
	
	/**
	 * User情報を登録、更新する.
	 * 
	 * @param user 登録、更新する情報の入ったドメイン
	 */
	public void save(User user) {
		StringBuilder sql = new StringBuilder();
		if (user.getId()==null) {
			SqlParameterSource param = new BeanPropertySqlParameterSource(user);
			sql.append("INSERT INTO ");
			sql.append(" users ");
			sql.append(" (name,   email,  password) ");
			sql.append("VALUES ");
			sql.append(" (:name, :email, :password) ");
			template.update(sql.toString(), param);			
		}else {
			SqlParameterSource param = new BeanPropertySqlParameterSource(user);
			sql.append("UPDATE ");
			sql.append(" users ");
			sql.append("SET ");
			sql.append(" name = :name ");
			sql.append("WHERE ");
			sql.append(" id = :id ");
			template.update(sql.toString(), param);
		}
	}
	
	/**
	 * emailからUser情報を取得する.
	 * 
	 * @param email ログイン画面で入力されたemail
	 * @return null又はemailから特定されたUser
	 */
	public User findByEmail(String email) {		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append(" id, name, email, password, admin ");
		sql.append("FROM ");
		sql.append(" users ");
		sql.append("WHERE ");
		sql.append(" email = :email ");
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		List<User> userList = template.query(sql.toString(), param, USER_ROW_MAPPER);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
	
	/**
	 * 登録されている全てのUser情報を取得する.
	 * 
	 * @return  登録されている全てのUser情報
	 * 
	 */
	public List<User> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append(" id, name, email, password, admin ");
		sql.append("FROM ");
		sql.append(" users ");
		List<User> userList = template.query(sql.toString(), USER_ROW_MAPPER);
		if (userList.size() == 0) {
			return null;
		}
		return userList;
	}
	
	/**
	 * idからユーザー情報を取得する.
	 * 
	 * @param id 一覧から選択されたid
	 * @return idから特定されたUser情報
	 */
	public User findById(Integer id) {		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append(" id, name, email, password, admin ");
		sql.append("FROM ");
		sql.append(" users ");
		sql.append("WHERE ");
		sql.append(" id = :id ");
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		User user = template.queryForObject(sql.toString(), param, USER_ROW_MAPPER);
		return user;
	}
	
	/**
	 * User情報を削除する.
	 * 
	 * @param id id
	 */
	public void delete(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE ");
		sql.append("FROM ");
		sql.append(" users ");
		sql.append("WHERE ");
		sql.append(" id = :id ");
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(sql.toString(), param);					
	}
	
}
