package model;

import java.io.Serializable;

public class Member implements Serializable {
	private Integer id;
	private String memberid;
	private String username;
	private String password;
	private String name;
	private String phone;
	private String sex;
	private String birthday;
	private String address;
	
	public Member(String memberid, String username, String password, String name, String phone, String sex,
			String birthday, String address) {
		super();
		this.memberid = memberid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}

	public Member() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
