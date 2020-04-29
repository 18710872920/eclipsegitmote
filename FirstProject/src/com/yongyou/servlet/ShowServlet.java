package com.yongyou.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yongyou.entity.Goods;
import com.yongyou.service.GoodsService;
import com.yongyou.service.impl.GoodsServiceImpl;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; 
	GoodsService goodsService = new GoodsServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
		this.doPost(req, resp); }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		List<Goods> list = goodsService.findGoods();
		req.setAttribute("goodsList", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
