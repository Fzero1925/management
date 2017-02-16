package management.entity;

import java.util.Date;

/**
 * 数据库对应的实体类
 * @author Fzero
 *
 */
public class Staff {
	
	private long id;
	
	private String name;
	
	private int gender;
	
	private String job;
	
	private long salary;
	
	private String fepartment;
	
	private String email;
	
	private Date regDate;

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name 
				+ ", gender=" + gender  + ", job=" 
				+ job + ", salary=" + salary
				+ ", fepartment=" + fepartment 
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
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

	public String getFepartment() {
		return fepartment;
	}

	public void setFepartment(String fepartment) {
		this.fepartment = fepartment;
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

	
}
