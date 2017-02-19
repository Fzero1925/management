package management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import management.dao.StaffDao;
import management.entity.Staff;
import management.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffDao staffDao;

	public List<Staff> queryStaffList() {
		List<Staff> staffList = staffDao.queryStaffList();
		return staffList;
	}

	@Transactional
	public String addStaff(Staff staff) {
		int result = staffDao.addStaff(staff);
		if(result > 0){
			return "success";
		}else{
			return "error";
		}
	}

	@Transactional
	public String deleteStaff(int id) {
		int result = staffDao.deleteStaff(id);
		if(result > 0){
			return "success";
		}else{
			return "error";
		}
	}

	@Transactional
	public String updateStaffs(Staff staff) {
		int result = staffDao.updateStaffs(staff);
		if(result > 0){
			return "success";
		}else{
			return "error";
		}
	}

}
