package com.yongyou.dao;

import java.util.List;

import com.yongyou.entity.Goods;

public interface GoodsDao {
	// ��ѯ����
	public List<Goods> findGoods();
	// ����
	public boolean addGoods(Goods goods);
	// ����id��ѯ
	public Goods queryById(int id);
	//�޸�
	public boolean updateGoods(Goods goods);
	// ɾ��
	public boolean deleteGoods(int id);

}
