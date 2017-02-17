package management.dao;

import org.apache.ibatis.annotations.Param;

import management.entity.Login;

public interface LoginDao {
	
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
	int addLoginUser(@Param("username") String username, @Param("passwrod") String password);

}
