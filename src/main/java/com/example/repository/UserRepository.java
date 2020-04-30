package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

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
}
