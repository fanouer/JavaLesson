package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sun.security.krb5.internal.PAEncTSEnc;
import util.DBUtil;

import entity.Cost;

public class CostDaoImpl implements CostDao {

	@Override
	public List<Cost> findAll() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from cost_lhh " +
				"order by cost_id";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Cost> list = 
				new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询资费失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

	/**
	 * Alt+Shift+M
	 */
	private Cost createCost(ResultSet rs) 
		throws SQLException {
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
	
	public static void main(String[] args) {
		CostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findByPage(3, 5);
		for(Cost c : list) {
			System.out.println(
				c.getCostId() + "," +
				c.getName());
		}
	}

	@Override
	public void save(Cost cost) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"insert into cost_lhh " +
				"values(cost_seq_lhh.nextval," +
				"?,?,?,?,'1',?,sysdate,null,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, cost.getName());
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"增加资费失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public Cost findById(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from cost_lhh " +
				"where cost_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return createCost(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询资费失败", e);
		} finally {
			DBUtil.close(con);
		}
		return null;
	}
	
	@Override
	public void update(Cost cost) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"update cost_lhh set " +
				"	name=?," +
				"	base_duration=?," +
				"	base_cost=?," +
				"	unit_cost=?," +
				"	descr=?," +
				" 	cost_type=? " +
				"where cost_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, cost.getName());
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.setInt(7, cost.getCostId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"修改资费失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	@Override
	public List<Cost> findByPage(
			int page, int size) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * form (" +
				"  select c.*,rownum r from(" +
				"    select * from cost_lhh " +
				"    order by cost_id" +
				"  ) c" +
				") where r between ? and ?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			int begin = (page-1)*size+1;
			int end = page*size;
			ps.setInt(1, begin);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			List<Cost> list = new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询资费失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	@Override
	public int findRows() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select count(*) from cost_lhh";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询总行数失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

}







