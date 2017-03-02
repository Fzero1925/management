package management.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		if(session.get("UserName") != null && !"".equals(session.get("UserName"))){
			String result = invocation.invoke();
			System.out.println("SessionInfo: " + session.get("UserName"));
			System.out.println("InvokeResult: " + result);
			return result;
		}else{
			return "login";
		}
	}

}
