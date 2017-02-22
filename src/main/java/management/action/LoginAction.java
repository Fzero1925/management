package management.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import management.dto.ManageCookie;
import management.entity.Login;
import management.service.LoginService;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<Login> {
	
	@Autowired
	private LoginService loginService;
	
	private Login login = new Login();
	
	
	public String login(){
/*		ManageCookie cookies = new ManageCookie();
		Map<String,Object> cookieMap = cookies.getCookie();*/
/*		Login loginInfo = loginService.check(cookieMap.get("username").toString(), 
											 cookieMap.get("password").toString());*/
		String username = login.getUsername();
		String password = login.getPassword();
		System.out.println(username);
		System.out.println(password);
		if(username == null || password == null){
			return "input";
		}
		Login loginInfo = loginService.check(username, password);
		if(loginInfo == null){
			this.addActionError("登录失败！！！");
			return "input";
		}
		return "success";
	}

	public Login getModel() {
		// TODO Auto-generated method stub
		return login;
	}

}
