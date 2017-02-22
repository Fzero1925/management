package management.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import management.dto.ManageCookie;
import management.entity.Staff;
import management.service.StaffService;

public class StaffAction extends ActionSupport {
	

	private int pageStart;
	private int pageEnd;

	
	@Autowired
	private StaffService staffService;
	
/*	@Autowired
	private ManageCookie manageCookie;*/
	
	/**
	 * 分页显示
	 */
/*	public String execute(){
		List<Staff> staffList = staffService.queryStaffList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("staffList", staffList);
		return SUCCESS;
	}	*/	
		
/*		for(Staff staff : staffList){
			request.setAttribute("id", staff.getId());
			request.setAttribute("name", staff.getName());
			request.setAttribute("gender", staff.getGender());
			request.setAttribute("job", staff.getJob());
			request.setAttribute("salary", staff.getSalary());
			request.setAttribute("email", staff.getEmail());
			request.setAttribute("regdate", staff.getRegDate());
		}*/
		
/*		List<Staff> staffList = staffService.queryStaffList();
		Map<String,List<Staff>> staffMap = new HashMap<String,List<Staff>>();
		staffMap.put("staffList", staffList);
		FreeMarkertUtil.analysisTemplate("staff.ftl", "UTF-8", staffMap);*/

	
	/**
	 * 根据ID删除员工信息
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String deleteById() throws UnsupportedEncodingException{
		ManageCookie manageCookie = new ManageCookie();
		Map<String,Object> cookieMap = manageCookie.getCookie();
		staffService.deleteById(Long.parseLong(cookieMap.get("staffId").toString()));
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
		staffService.addStaff(cookieMap.get("name").toString(), 
							  cookieMap.get("gender").toString(), 
							  cookieMap.get("job").toString(), 
							  Long.parseLong(cookieMap.get("salary").toString()), 
							  cookieMap.get("email").toString());
		return SUCCESS;
	}
	
	public String queryByPage() throws UnsupportedEncodingException{
		ManageCookie manageCookie = new ManageCookie();
		Map<String, Object> cookieMap = manageCookie.getCookie();
		int pageNum = Integer.parseInt(cookieMap.get("pageNum").toString());
		if(pageNum > 1){
			pageStart = ((pageNum - 1) * 5) + 1;
			pageEnd = pageNum * 5;
		}else if(pageNum == 1){
			pageStart = 1;
			pageEnd = 5;
		}else{
			//TODO
		}
		List<Staff> staffList = staffService.queryByPage(pageStart, pageEnd);
		HttpServletRequest request = manageCookie.getRequest();
		request.setAttribute("staffList", staffList);
		/*ActionContext.getContext().getValueStack().push(staffList);*/
		return SUCCESS;
	}

}
