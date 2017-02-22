package management.dao;

import org.apache.ibatis.annotations.Param;

import management.entity.Login;

public interface LoginDao {
	
	/**
	 * 获取指定登录用户信息
	 */
	Login check(@Param("username") String username, @Param("password") String password);

}
