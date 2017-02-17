package management.entity;

public class Position {
	
	private long id;
	
	private String job;

	@Override
	public String toString() {
		return "Position [id=" + id + ", job=" + job + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	
}
