package management.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class ManageCookie {
	
	private HttpServletRequest request;
	
	private Cookie[] cookies;
	
	public Map<String,Object> getCookie() {
		request = ServletActionContext.getRequest();
		cookies = request.getCookies();
		Map<String, Object> cookieMap = new HashMap<String, Object>();
		for(Cookie cookie : cookies){
			 try {
				cookieMap.put(cookie.getName(), URLDecoder.decode(cookie.getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cookieMap;
	}
	
	public ManageCookie(){
		
	}

	@Override
	public String toString() {
		return "ManageCookie [request=" + request + ", cookies=" + Arrays.toString(cookies) + "]";
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Cookie[] getCookies() {
		return cookies;
	}

	public void setCookies(Cookie[] cookies) {
		this.cookies = cookies;
	}
	
	

}
