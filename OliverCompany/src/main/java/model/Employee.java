package model;

import java.io.Serializable;

public class Employee implements Serializable {
	Integer id;
	String employeeid;
	String name;
	String idnumber;
	String password;
	String phone;
	String address;
	String permission;
	String status;
	
	public Employee(String employeeid, String name, String idnumber, String password, String phone, String address,
			String permission, String status) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.idnumber = idnumber;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.permission = permission;
		this.status = status;
	}
	
	public Employee() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}

