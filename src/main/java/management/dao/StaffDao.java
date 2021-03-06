package management.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import management.entity.Staff;

public interface StaffDao {
	
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
	int addStaff(@Param("name") String name, 
				 @Param("gender") String gender, 
				 @Param("job") String job, 
				 @Param("salary") long salary, 
				 @Param("email") String email);
	
	/**
	 * 删除员工信息
	 * @param staffId
	 * @return
	 */
	int deleteById(long id);
	
	/**
	 * 分页查询
	 * @param pageStart
	 * @param pageEnd
	 * @return
	 */
	List<Staff> queryByPage(@Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd);
	
	/**
	 * 更新员工信息（涨工资等）
	 * @param staffId
	 * @return
	 */
	int updateStaffs(Staff staff);

	/**
	 * 批量删除员工信息
	 * @param idList
	 */
	void deleteBatch(List<Integer> idList);

}
