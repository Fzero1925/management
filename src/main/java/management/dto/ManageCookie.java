package management.dto;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class ManageCookie {
	
	public Map<String,Object> getCookie(String name){
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		Map<String, Object> cookieMap = new HashMap<String, Object>();
		for(Cookie cookie : cookies){
			 cookieMap.put(cookie.getName(), cookie.getValue());
		}
		return cookieMap;
	}

}
