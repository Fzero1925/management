package management.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
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
		//获取验证码
		String kaptchaExpected = (String)ActionContext.getContext().getSession().get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//获取用户输入的验证码
		String kaptcha = login.getKaptcha();
		System.out.println(username);
		System.out.println(password);
		System.out.println(kaptcha);
		//这个判断之所以写在最前面，因为刚打开登录页面的时候input的值就通过Struts2的数据模型传递过来了
		//刚开始username与password是null，kaptcha是空，所以要先拦截下来
		if(kaptcha == null || kaptcha.equals("") || username == null || password == null ){
			return "input";
		}
		if(!kaptcha.equals(kaptchaExpected)){
			this.addActionError("验证码错误！！！");
			return "input";
		}
		Login loginInfo = loginService.check(username, password);
		if(loginInfo == null){
			this.addActionError("登录失败！！！");
			return "input";
		}else{
			return "success";
		}
	}

	public Login getModel() {
		// TODO Auto-generated method stub
		return login;
	}

}
