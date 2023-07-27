package hw08;

public class Person {
	private String name;
	private String email;
	private String mobile;
	private String addr;
	
	public Person(String name, String email, String mobile, String addr) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.addr = addr;
	}
	public Person() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", mobile=" + mobile + ", addr=" + addr + "]";
	}
}
