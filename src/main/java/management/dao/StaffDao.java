package management.dao;

import java.util.List;

import management.entity.Staff;

public interface StaffDao {
	
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
	int addStaff(Staff staff);
	
	/**
	 * 删除员工信息
	 * @param staffId
	 * @return
	 */
	int deleteStaff(int id);
	
	/**
	 * 更新员工信息（涨工资等）
	 * @param staffId
	 * @return
	 */
	int updateStaffs(Staff staff);

}
