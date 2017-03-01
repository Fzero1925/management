package management.service;

import java.util.List;

import management.entity.Staff;

public interface StaffService {
	
	/**
	 * 查询所有员工信息
	 * @param staffId
	 * @return
	 */
	List<Staff> queryStaffList();
	
	/**
	 * 增加员工
	 * @param staff
	 * @return
	 */
	void addStaff(String name, String gender, String job, long salary, String email);
	
	/**
	 * 删除员工信息
	 * @param staffId
	 * @return
	 */
	void deleteById(long id);
	
	/**
	 * 分页查询
	 * @param pageStart
	 * @param pageEnd
	 * @return
	 */
	List<Staff> queryByPage (int pageStart, int pageEnd);
	
	/**
	 * 更新员工信息（涨工资等）
	 * @param staffId
	 * @return
	 */
	String updateStaffs(Staff staff);

	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteBatch(String[] ids);

}
