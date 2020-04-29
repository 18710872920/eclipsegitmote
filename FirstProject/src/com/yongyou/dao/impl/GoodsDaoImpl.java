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
	 * 查询全部
	 */
	@Override
	public List<Goods> findGoods() {
		Connection conn = DbHelper.getConnection();
		
		List<Goods> list = new ArrayList<Goods>();
		// 查询语句
		String sql = "select * from goods";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// 遍历放入集合中
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				
				list.add(goods);
			}
			rs.close();//关闭
			ps.close();// 关闭
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
		

	}
	/*
	 * 添加
	 */
	@Override
	public boolean addGoods(Goods goods) {
		Connection conn = DbHelper.getConnection();
		String sql = "insert into goods(id,name,price) VALUES (?,?,?) ";// 添加的sql语句
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql); 
			pst.setInt(1, goods.getId()); 
			pst.setString(2, goods.getName()); 
			pst.setDouble(3, goods.getPrice()); 
			int count = pst.executeUpdate(); 
			pst.close();
			return count>0?true:false; //是否添加的判断 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	/*
	 * 根据id查询
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
		return goods;// 返回
	}
	/*
	 * 修改
	 */
	@Override
	public boolean updateGoods(Goods goods) {
		Connection conn = DbHelper.getConnection();
		String sql = "update goods set name=?,price=? where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql); 
			pst.setString(1, goods.getName()); 
			pst.setDouble(2, goods.getPrice()); 
			pst.setInt(3, goods.getId()); //根据的ID 
			int count = pst.executeUpdate(); 
			pst.close(); //关闭
			return count>0?true:false; //是否修改的判断 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * 删除
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
			return count>0?true:false; //是否删除的判断
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
