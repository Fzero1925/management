package management.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import management.dto.ManageCookie;
import management.entity.Staff;
import management.service.StaffService;

@SuppressWarnings("serial")
public class StaffAction extends ActionSupport  {
	
	@Autowired
	private StaffService staffService;
	
/*	@Autowired
	private ManageCookie manageCookie;*/
	
	private List<Staff> list = new ArrayList<Staff>();
	
	public List<Staff> getList(){
		return list;
	}
	
	/**
	 * 初始化显示
	 */
	public String execute(){
		int pageStart = 1;
		List<Staff> staffList = staffService.queryStaffList();
		for(int i = 1; i <= 5; i++){
			list.add(staffList.get(pageStart));
			pageStart = pageStart + 1;
			if(pageStart == staffList.size()){
				break;
			}
		}
		
		//传递页数和当前页
		//1、获取值栈对象
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		
		//2、调用值栈对象中的set方法
		double sumPage = Math.ceil(staffList.size() / 5.0);
		stack.set("sumPage", (int)sumPage);
		stack.set("currentPage", 1);
		return SUCCESS;
	}		
		

	
	/**
	 * 根据ID删除员工信息
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String deleteById() throws UnsupportedEncodingException{
		/*ManageCookie manageCookie = new ManageCookie();
		Map<String,Object> cookieMap = manageCookie.getCookie();
		staffService.deleteById(Long.parseLong(cookieMap.get("staffId").toString()));*/
		HttpServletRequest request = ServletActionContext.getRequest();
		long id = Long.parseLong(request.getParameter("id"));
		staffService.deleteById(id);
		return SUCCESS;
	}
	
	
	/**
	 * 添加员工
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String addStaff() throws UnsupportedEncodingException{
		ManageCookie manageCookie = new ManageCookie();
		Map<String,Object> cookieMap = manageCookie.getCookie();
		System.out.println(cookieMap.get("job").toString());
		staffService.addStaff(cookieMap.get("name").toString(), 
							  cookieMap.get("gender").toString(), 
							  cookieMap.get("job").toString(), 
							  Long.parseLong(cookieMap.get("salary").toString()), 
							  cookieMap.get("email").toString());
		return SUCCESS;
	}
	
	public String queryByPage(){
		//获取response对象，用户设置Cookie信息
		HttpServletResponse response = ServletActionContext.getResponse();
		//获取request对象，获取前端传递过来的Cookie和通过URL传递的参数
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies= request.getCookies();
		System.out.println("cookies: " + cookies);
		//对传递过来的指定页码进行格式转换
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		System.out.println("pagepageNum: " + pageNum);
		//对要跳转的页码进行判断，如果小于1，直接返回
		if(pageNum >= 1){
			//设置将要跳转的页面的第一条数据的伪列号
			int pageStart = ((pageNum - 1) * 5) + 1;
			/*int pageEnd = pageNum * 5;*/
			//获取全部数据，方便计算总页数
			List<Staff> staffList = staffService.queryStaffList();
			System.out.println("pagepageStaffList: " + staffList.size());
			//判断页面第一条数据的伪列号是否小于总行数，如果大于，说明没有相应的数据可以显示，直接返回
			if(staffList.size() >= pageStart){
				//数据存放在List中，第一个元素为0
				pageStart = pageStart - 1;
				for(int i = 1; i <= 5; i++){//设置一个页面最多5条信息
					//因为之前已经判断页面第一条数据的伪列号小于总行数，所以至少有一条数据
					list.add(staffList.get(pageStart));
					pageStart = pageStart + 1;
					//如果下一条数据的下标等于总行数，说明此时已经没有数据了
					if(pageStart == staffList.size()){
						System.out.println("pagepageifstart: " + pageStart);
						System.out.println("pagepageifsize: " + staffList.size());
						break;
					}
				}
				//传递页数和当前页
				//1、获取值栈对象
				ActionContext context = ActionContext.getContext();
				ValueStack stack = context.getValueStack();
				
				//2、调用值栈对象中的set方法
				double sumPage = Math.ceil(staffList.size() / 5.0);
				System.out.println("sumPage: " + (int)sumPage);
				System.out.println("pageNUmm: " + pageNum);
				//向值栈中设置要传递的参数
				stack.set("sumPage", (int)sumPage);
				stack.set("currentPage", pageNum);
				Cookie cookie1 = new Cookie("pageInfo", "");
				response.addCookie(cookie1);
				/*String currentPage = request.getParameter("currentPage");
				Cookie cookie2 = new Cookie("currentPage", currentPage);
				response.addCookie(cookie2);*/
				return SUCCESS;
			}else{
				Cookie cookie = new Cookie("pageInfo", "noData");
				response.addCookie(cookie);
				System.out.println(cookie);
				return SUCCESS;
			}
		}else{
			Cookie cookie = new Cookie("pageInfo", "noPage");
			response.addCookie(cookie);
			System.out.println(cookie);
			return SUCCESS;
		}
	}
	
	/**
	 * 批量删除
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String deleteBatch() throws UnsupportedEncodingException{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String[] ids = request.getParameterValues("ids");
		staffService.deleteBatch(ids);
		return "input";
	}

}
