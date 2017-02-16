package management.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import management.entity.Staff;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StaffDaoTest {
	
	@Autowired
	private StaffDao staffDao;

	@Test
	public void testQueryStaffById() {
		long id = 3;
		Staff staff = staffDao.queryStaffById(id);
		System.out.println(staff.getName());
		System.out.println(staff);
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
