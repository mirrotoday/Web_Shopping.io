package com.itheima.web.servlet;

import com.itheima.domain.Product;

import com.itheima.service.ProductService;

import com.itheima.service.impl.ProductServiceImpl;
import com.itheima.web.servlet.base.BaseServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页模块
 */
@WebServlet("/index")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.调用productservice查询最新商品 和 热门商品
		try {
			ProductService ps = new ProductServiceImpl();
			List<Product> hotList=ps.findHot();
			List<Product> newList=ps.findNew();
			System.out.println(hotList.size());
			
			//2.将两个list都放入request域中
			request.setAttribute("hList", hotList);
			request.setAttribute("nList", newList);
		} catch (Exception e) {			
		}
		return "/jsp/index.jsp";
	}
   
}
