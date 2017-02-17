package management.service.impl;

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

	public Staff queryStaffById(long id) {
		return staffDao.queryStaffById(id);
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
