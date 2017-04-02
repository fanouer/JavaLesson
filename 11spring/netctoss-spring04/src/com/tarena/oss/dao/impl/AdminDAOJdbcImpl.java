package com.tarena.oss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.tarena.oss.dao.AdminDAO;
import com.tarena.oss.entity.Admin;
/**
 * DAOʵ����
 */
@Repository("adminDAO")
public class AdminDAOJdbcImpl 
implements AdminDAO{
	@Resource(name="dataSource")
	private DataSource ds;

	public Admin findByCode(String code) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			conn = ds.getConnection();
			String sql = 
				"SELECT * FROM admin_info_lhh " +
				"WHERE admin_code=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, code);
			rst = stat.executeQuery();
			if(rst.next()){
				admin = new Admin();
				admin.setAdminId(rst.getInt("admin_id"));
				admin.setAdminCode(rst.getString("admin_code"));
				admin.setPassword(rst.getString("password"));
				admin.setName(rst.getString("name"));
				admin.setTelephone(rst.getString("telephone"));
				admin.setEmail(rst.getString("email"));
				admin.setEnrolldate(rst.getTimestamp("enrolldate"));
			}
		} catch (SQLException e) {
			//step1,����־
			e.printStackTrace();
			/*
			 * step2,���쳣�ܲ��ܹ��ָ���
			 * ������ܹ�(������ϵͳ
			 * �쳣�����磬���ݿ������ͣ,
			 * �����ж�)������ʾ�û��Ժ����ԡ�
			 * ����ܹ��ָ����������ָ���
			 */
			throw new RuntimeException(e);
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return admin;
	}
	
	
	
	
	

}
