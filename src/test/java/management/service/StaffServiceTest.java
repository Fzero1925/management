package management.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import management.entity.Staff;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
					   "classpath:spring/spring-service.xml"})
public class StaffServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StaffService staffService;

	@Test
	public void testQueryStaffById() {
		long id = 2;
		Staff staff = staffService.queryStaffById(id);
		logger.info("staff={}", staff);
	}

	@Test
	public void testAddStaff() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteStaff() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateStaffs() {
		fail("Not yet implemented");
	}

}
