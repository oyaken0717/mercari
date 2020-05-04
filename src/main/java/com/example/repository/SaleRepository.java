package com.example.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.domain.Sale;

@Repository
public class SaleRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
    private SimpleJdbcInsert insert;
    
    @PostConstruct
    public void init() {
        insert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcTemplate()); 
        insert = insert.withTableName("sales").usingGeneratedKeyColumns("id");
    }

	
	public static final RowMapper<Sale> SALE_ROW_MAPPER = (rs,i)->{
		Sale sale = new Sale();
		sale.setId(rs.getInt("id"));
		sale.setItemId(rs.getInt("item_id"));
		sale.setPrice(rs.getDouble("price"));
		sale.setTerm(rs.getDate("term"));
		return sale;
	};
	
	public Sale save(Sale sale){
		SqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		if (sale.getId()==null) {
            Number key = insert.executeAndReturnKey(param);
            sale.setId(key.intValue());        	
		}
		return sale;
	}
}
