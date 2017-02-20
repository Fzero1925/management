package management.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import management.dto.ManageCookie;
import management.entity.Staff;
import management.service.StaffService;

public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
	
/*	@Autowired
	private Staff staff;*/
	
	@Autowired
	private StaffService staffService;
	
/*	@Autowired
	private ManageCookie manageCookie;*/
	
	public String execute(){
		List<Staff> staffList = staffService.queryStaffList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("staffList", staffList);
		
		
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
		return SUCCESS;
	}
	
	public String deleteById() throws UnsupportedEncodingException{
		ManageCookie manageCookie = new ManageCookie();
		Map<String,Object> cookieMap = manageCookie.getCookie();
		staffService.deleteById(Long.parseLong(cookieMap.get("staffId").toString()));
		return SUCCESS;
	}
	
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

	public Staff getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
