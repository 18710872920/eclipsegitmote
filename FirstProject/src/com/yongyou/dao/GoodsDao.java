package com.yongyou.dao;

import java.util.List;

import com.yongyou.entity.Goods;

public interface GoodsDao {
	// 查询所有
	public List<Goods> findGoods();
	// 增加
	public boolean addGoods(Goods goods);
	// 根据id查询
	public Goods queryById(int id);
	//修改
	public boolean updateGoods(Goods goods);
	// 删除
	public boolean deleteGoods(int id);

}
