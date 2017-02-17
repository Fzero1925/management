package management.service;

import management.entity.Staff;

public interface StaffService {
	
	/**
	 * 根据id查询员工信息
	 * @param staffId
	 * @return
	 */
	Staff queryStaffById(long id);
	
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
	String deleteStaff(int id);
	
	/**
	 * 更新员工信息（涨工资等）
	 * @param staffId
	 * @return
	 */
	String updateStaffs(Staff staff);

}
