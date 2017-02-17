package management.service;

import org.apache.ibatis.annotations.Param;

import management.entity.Login;

public interface LoginService {
	
	/**
	 * 查询登录用户信息
	 * @param username
	 * @return
	 */
	Login queryLoginByName(String username);
	
	/**
	 * 增加登录用户
	 * @param username
	 * @param password
	 * @return
	 */
	String addLoginUser(String username, String password);

}
