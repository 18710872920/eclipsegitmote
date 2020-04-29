package com.yongyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yongyou.dao.GoodsDao;
import com.yongyou.entity.Goods;
import com.yongyou.util.DbHelper;

public class GoodsDaoImpl implements GoodsDao {

	/*
	 * ��ѯȫ��
	 */
	@Override
	public List<Goods> findGoods() {
		Connection conn = DbHelper.getConnection();
		
		List<Goods> list = new ArrayList<Goods>();
		// ��ѯ���
		String sql = "select * from goods";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// �������뼯����
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				
				list.add(goods);
			}
			rs.close();//�ر�
			ps.close();// �ر�
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
		

	}
	/*
	 * ���
	 */
	@Override
	public boolean addGoods(Goods goods) {
		Connection conn = DbHelper.getConnection();
		String sql = "insert into goods(id,name,price) VALUES (?,?,?) ";// ��ӵ�sql���
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql); 
			pst.setInt(1, goods.getId()); 
			pst.setString(2, goods.getName()); 
			pst.setDouble(3, goods.getPrice()); 
			int count = pst.executeUpdate(); 
			pst.close();
			return count>0?true:false; //�Ƿ���ӵ��ж� 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	/*
	 * ����id��ѯ
	 */
	@Override
	public Goods queryById(int id) {
		Connection conn = DbHelper.getConnection();
		String sql = "select * from goods where id = "+id;
		Goods goods = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql); 
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				goods = new Goods(); 
				goods.setId(rst.getInt("id")); 
				goods.setName(rst.getString("name")); 
				goods.setPrice(rst.getDouble("price"));
			}
			rst.close();
			pst.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return goods;// ����
	}
	/*
	 * �޸�
	 */
	@Override
	public boolean updateGoods(Goods goods) {
		Connection conn = DbHelper.getConnection();
		String sql = "update goods set name=?,price=? where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql); 
			pst.setString(1, goods.getName()); 
			pst.setDouble(2, goods.getPrice()); 
			pst.setInt(3, goods.getId()); //���ݵ�ID 
			int count = pst.executeUpdate(); 
			pst.close(); //�ر�
			return count>0?true:false; //�Ƿ��޸ĵ��ж� 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * ɾ��
	 */
	@Override
	public boolean deleteGoods(int id) {
		Connection conn = DbHelper.getConnection();
		String sql = "delete from goods where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql); 
			pst.setInt(1, id); 
			int count = pst.executeUpdate(); 
			pst.close();
			return count>0?true:false; //�Ƿ�ɾ�����ж�
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
