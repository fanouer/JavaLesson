package com.tarena.oss.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tarena.oss.dao.CostDAO;
import com.tarena.oss.entity.Cost;
@Repository("costDAO")
public class CostDAOJdbcImpl implements CostDAO{
	@Resource(name="jt")
	private JdbcTemplate jt;
	public List<Cost> findAll() {
		String sql = "SELECT * FROM cost_lhh " +
		"ORDER BY cost_id";
		return jt.query(sql, new CostRowMapper());
	}
	
	class CostRowMapper implements RowMapper<Cost>{

		public Cost mapRow(ResultSet rs, int index) throws SQLException {
			Cost c = new Cost();
			c.setCostId(rs.getInt("cost_id"));
			c.setName(rs.getString("name"));
			c.setBaseDuration(rs.getInt("base_duration"));
			c.setBaseCost(rs.getDouble("base_cost"));
			c.setUnitCost(rs.getDouble("unit_cost"));
			c.setStatus(rs.getString("status"));
			c.setDescr(rs.getString("descr"));
			c.setCreatime(rs.getTimestamp("creatime"));
			c.setStartime(rs.getTimestamp("startime"));
			c.setCostType(rs.getString("cost_type"));
			return c;
		}
		
	}

}
