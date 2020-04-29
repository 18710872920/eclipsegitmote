package com.yongyou.service.impl;

import java.util.List;

import com.yongyou.dao.GoodsDao;
import com.yongyou.dao.impl.GoodsDaoImpl;
import com.yongyou.entity.Goods;
import com.yongyou.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	// ��Ҫ����dao�������ɾ�Ĳ�   ��߽ӿڣ��ұ�ʵ����
	private GoodsDao goodsdao = new GoodsDaoImpl();
	
	@Override
	public List<Goods> findGoods() {
		// TODO Auto-generated method stub
		return goodsdao.findGoods();
	}

	@Override
	public boolean addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsdao.addGoods(goods);
	}

	@Override
	public Goods queryById(int id) {
		// TODO Auto-generated method stub
		return goodsdao.queryById(id);
	}

	@Override
	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsdao.updateGoods(goods);
	}

	@Override
	public boolean deleteGoods(int id) {
		// TODO Auto-generated method stub
		return goodsdao.deleteGoods(id);
	}

}
