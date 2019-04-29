package com.itheima.dao;

import com.itheima.domain.User;
/**
 * 
 * @author 一场追逐，不曾停歇
 *
 */
public interface UserDao {

	void save(User user) throws Exception;

	User getByCode(String code) throws Exception;

	void update(User user) throws Exception;

	User getByUsernameAndPwd(String username, String password) throws Exception;

}
