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
		// 从View视图层接收数据
	
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		
		//javaBean里面的用户名，密码 
		Goods goods = new Goods(); //javaBean里面的用户名，密码 	
		// 转值，中文需要转换为utf-8
		goods.setName(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
		goods.setPrice(price);
		
		goodsService.addGoods(goods);// service层
		req.getRequestDispatcher("ShowServlet").forward(req, resp);
	}
	
	
	

}
