package management.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import management.dto.ManageCookie;
import management.entity.Login;
import management.service.LoginService;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<Login>, SessionAware {
	
	@Autowired
	private LoginService loginService;
	
	//为了使用ModelDriven
	private Login login = new Login();
	
	private Map<String, Object> session;
	
	
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
		//首先清除Session中有关登录的信息
		//否则用户在点击退出按钮的时候，还能通过URL直接进入列表页
		if(session.get("UserName") != null){
			session.put("UserName", "");
		}
		//这个判断之所以写在最前面，因为刚打开登录页面的时候input的值就通过Struts2的数据模型传递过来了
		//刚开始username与password是null，kaptcha是空，所以要先拦截下来
		if(kaptcha == null || kaptcha.equals("") || username == null || password == null ){
			return "input";
		}else if(!kaptcha.equals(kaptchaExpected)){
			this.addActionError("验证码错误！！！");
			return "input";
		}
		//通过值栈中的用户名和密码作为参数对数据库进行查询，如果不符合条件，返回的数据为null
		Login loginInfo = loginService.check(username, password);
		if(loginInfo == null){
			//返回的数据为null，说明用户名或者密码错误
			this.addActionError("登录失败！！！");
			return "input";
		}else if(loginInfo.getUsername().equals("admin") && loginInfo.getPassword().equals("admin")){
			//判断登录的用户是否是admin用户，如果是admin用户，则没有限制
			session.put("UserName", loginInfo.getUsername());
			return "success";
		}else{
			//如果登录用户是普通用户，在前端页面可以使用Struts2的if标签进行判断，对用户行为进行控制
			session.put("UserName", loginInfo.getUsername());
			return "success";
		}
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Login getModel() {
		// TODO Auto-generated method stub
		return login;
	}

}
