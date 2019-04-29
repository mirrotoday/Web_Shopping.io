package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.impl.CategoryDaoImpl;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.JsonUtil;

public class CategoryServiceImpl implements CategoryService {

	@Override
	/**
	 * 查询所有分类
	 */
	public String findAll() throws Exception {
		/*//1.调用dao 查询所有分类
		CategoryDao cd = new CategoryDaoImpl();
		List<Category> list = cd.findAll();*/
		
		List<Category> list=findList();
		
		//2.将list转换成json字符串
		if(list!=null && list.size()>0){
			return JsonUtil.list2json(list);
		}
		return null;
	}
	@Override
	/**
	 * 后台展示所有分类
	 */
	public List<Category> findList() throws Exception {
		CategoryDao cd = (CategoryDao) BeanFactory.getBean("CategoryDao");
		return cd.findAll();
	}

	@Override
	public String findAllFromRedis() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	/**
	 * 添加分类
	 */
	public void save(Category c) throws Exception {
		//1.调用dao 完成添加
		CategoryDao cd = (CategoryDao) BeanFactory.getBean("CategoryDao");
		cd.save(c);
		//2.更新redis
				/*
				Jedis j = null;
				try {
					j=JedisUtils.getJedis();
					//清除redis中数据
					j.del(Constant.STORE_CATEGORY_LIST);
				} finally {
					JedisUtils.closeJedis(j);
				}
				*/
	}


}
