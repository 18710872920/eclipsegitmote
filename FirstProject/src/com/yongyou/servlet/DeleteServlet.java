package com.yongyou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yongyou.service.GoodsService;
import com.yongyou.service.impl.GoodsServiceImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	GoodsService goodsService = new GoodsServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
		this.doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		String idStr = req.getParameter("id"); //删除数据的ID，根据ID删除 
		if(idStr != null && !idStr.equals("")){ 
			int id = Integer.valueOf(idStr); 
			goodsService.deleteGoods(id); 
			}
		req.getRequestDispatcher("ShowServlet").forward(req, resp);
	}

}
