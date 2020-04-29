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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	GoodsService goodsService = new GoodsServiceImpl(); 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//查询到选中ID的值所对应的数据 
		String idStr = req.getParameter("id"); 
		if(idStr != null && !idStr.equals("")){ 
			int id = Integer.valueOf(idStr); 
			Goods goods = goodsService.queryById(id); 
			req.setAttribute("goods", goods); 
			}
		req.getRequestDispatcher("update.jsp").forward(req, resp); 
		}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
		//根据此ID对数据的值进行修改 
		String name = req.getParameter("name"); 
		double price = Double.parseDouble(req.getParameter("price")); 
		String idStr = req.getParameter("id"); 
		Goods goods = new Goods(); 
		goods.setId(Integer.valueOf(idStr)); 
		goods.setName(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
		goods.setPrice(price); 
		
		goodsService.updateGoods(goods); 
		req.getRequestDispatcher("ShowServlet").forward(req, resp);
	}

}
