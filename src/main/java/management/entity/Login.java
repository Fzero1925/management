package management.entity;

public class Login {
	
	private String username;
	
	private String password;
	
	//存放用户输入的验证码信息
	private String kaptcha;

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", kaptcha=" + kaptcha + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKaptcha() {
		return kaptcha;
	}

	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}

}
