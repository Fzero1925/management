package management.service;

import java.util.List;

import management.entity.Staff;

public interface StaffService {
	
	/**
	 * 根据id查询员工信息
	 * @param staffId
	 * @return
	 */
	List<Staff> queryStaffList();
	
	/**
	 * 增加员工
	 * @param staff
	 * @return
	 */
	String addStaff(Staff staff);
	
	/**
	 * 删除员工信息
	 * @param staffId
	 * @return
	 */
	void deleteById(long id);
	
	/**
	 * 更新员工信息（涨工资等）
	 * @param staffId
	 * @return
	 */
	String updateStaffs(Staff staff);

}
