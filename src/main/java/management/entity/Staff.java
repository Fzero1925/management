package management.entity;

import java.util.Date;

/**
 * 数据库对应的实体类
 * @author Fzero
 *
 */
public class Staff {
	
/*	//虚列，用于分页查询
	private int rnum;*/
	
	private long id;
	
	private String name;
	
	private String gender;
	
	private String job;
	
	private long salary;
	
	private String department;
	
	private String email;
	
	private Date regDate;

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name 
				+ ", gender=" + gender  + ", job=" 
				+ job + ", salary=" + salary
				+ ", department=" + department 
				+ ", email=" + email + ", regDate=" 
				+ regDate 
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

/*	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}*/

	
}
