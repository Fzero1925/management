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

	@Transactional
	public Login queryLoginByName(String username) {
		return loginDao.queryLoginByName(username);
	}

	@Transactional
	public String addLoginUser(String username, String password) {
		int result = loginDao.addLoginUser(username, password);
		if(result > 0){
			return "success";
		}else{
			return "error";
		}
	}

}
