package com.yongyou.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yongyou.entity.Goods;
import com.yongyou.service.GoodsService;
import com.yongyou.service.impl.GoodsServiceImpl;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	GoodsService goodsService = new GoodsServiceImpl();
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
		this.doPost(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��View��ͼ���������
	
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		
		//javaBean������û��������� 
		Goods goods = new Goods(); //javaBean������û��������� 	
		// תֵ��������Ҫת��Ϊutf-8
		goods.setName(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
		goods.setPrice(price);
		
		goodsService.addGoods(goods);// service��
		req.getRequestDispatcher("ShowServlet").forward(req, resp);
	}
	
	
	

}
