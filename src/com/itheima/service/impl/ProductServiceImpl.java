package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.ProductDao;
import com.itheima.dao.impl.ProductDaoImpl;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;

public class ProductServiceImpl implements ProductService {
	@Override
	//查询热门商品
	public List<Product> findHot() throws Exception {
		// TODO Auto-generated method stub
		ProductDao pd = new ProductDaoImpl();
		return pd.findHot();
	
	}

	@Override
	//查询最新商品
	public List<Product> findNew() throws Exception {
		// TODO Auto-generated method stub
		ProductDao pd = new ProductDaoImpl();
		return pd.findNew();
	}

	@Override
	public Product getById(String pid) throws Exception {
		// TODO Auto-generated method stub
		ProductDao pd = new ProductDaoImpl();
		
		return pd.getById(pid);
	}

	@Override
	/**
	 * 分页展示分类商品
	 */
	public PageBean<Product> findByPage(int pageNumber, int pageSize, String cid) throws Exception {
		ProductDao pDao= new ProductDaoImpl();
		//1.创建pagebean
		PageBean<Product> pb = new PageBean<>(pageNumber, pageSize);
		
		//2.设置当前页数据
		List<Product> data = pDao.findByPage(pb,cid);
		pb.setData(data);
		
		//3.设置总记录数
		int totalRecord = pDao.getTotalRecord(cid);
		pb.setTotalRecord(totalRecord);
		
		return pb;
	}

	@Override
	/**
	 * 保存商品
	 */
	public void save(Product p) throws Exception {
		ProductDao pDao= (ProductDao) BeanFactory.getBean("ProductDao");
		pDao.save(p);
		
	}	

	@Override
	public List<Product> findAll() throws Exception {
		ProductDao pDao = (ProductDao) BeanFactory.getBean("ProductDao");
		return pDao.findall();
	}

}
