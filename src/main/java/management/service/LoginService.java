package management.service;

import management.entity.Login;

public interface LoginService {
	
	
	/**
	 * 验证登录用户
	 * @param username
	 * @param password
	 * @return
	 */
	Login check(String username, String password);

}
