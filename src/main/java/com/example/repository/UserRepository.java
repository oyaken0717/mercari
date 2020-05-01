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
		}
	}
	
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

}
