package management.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import management.entity.Staff;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class StaffDaoTest {
	
	@Autowired
	private StaffDao staffDao;

	@Test
	public void testQueryStaffById() {
		List<Staff> staffList = staffDao.queryStaffList();
		System.out.println(staffList);
	}

	@Test
	public void testAddStaff() {
	}

	@Test
	public void testDeleteStaff() {
	}

	@Test
	public void testUpdateStaffs() {
	}

}
