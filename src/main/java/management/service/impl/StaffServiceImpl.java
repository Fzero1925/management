package management.service.impl;

import java.util.ArrayList;
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

	/**
	 * 增加员工
	 */
	@Transactional
	public void addStaff(String name, String gender, String job, long salary, String email) {
		staffDao.addStaff(name, gender, job, salary, email);
	}

	/**
	 * 根据ID删除员工信息
	 */
	@Transactional
	public void deleteById(long id) {
		staffDao.deleteById(id);
	}

	/**
	 * 分页查询
	 */
	@Transactional
	public List<Staff> queryByPage(int pageStart, int pageEnd) {
		List<Staff> staffList = staffDao.queryByPage(pageStart, pageEnd);
		return staffList;
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

	/**
	 * 批量删除员工信息
	 */
	public void deleteBatch(String[] ids) {
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids){
			idList.add(Integer.valueOf(id));
		}
		staffDao.deleteBatch(idList);
	}

}
