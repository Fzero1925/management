package management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import management.dao.LoginDao;
import management.entity.Login;
import management.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	/**
	 * 验证登录用户
	 */
	@Transactional
	public Login check(String username, String password) {
		Login loginInfo = loginDao.check(username, password);
		return loginInfo;
	}

}
