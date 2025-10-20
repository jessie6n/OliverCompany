package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	//create
	public boolean addEmployee(Employee employee);
	
	
	//read
	public Employee employeeLogin(String employeeid, String password);
	public Employee selectByEmployeeid(String employeeid);
	public List<Employee> selectByInput(String employeeid,String name,String idnumber,String phone,String address,String permission, String status);
	public List<Employee> selectSales();
	
	//update
	public boolean updateEmployee(Employee employee);
	public boolean resetPassword(String employeeid);
	public boolean updatePassword(String employeeid,String password);
	
	//delete
	
	
	

	
	
	

}
