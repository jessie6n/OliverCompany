package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	//create
	public boolean insertEmployee(Employee employee);
	
	//read
	public Employee selectByIdAndPw(String id, String password);
	public Employee selectByEmployeeid(String employeeid);
	public String addEmployeeid();
	public List<Employee> selectByInput(String employeeid, String name, String idnumber, String phone, String address,
			String permission, String status);
	public List<Employee> selectSales();
	
	
	
	//update
	public boolean updateEmployee(Employee employee);
	public boolean resetPassword(String employeeid);
	public boolean updatePassword(String employeeid,String password);
	
	
	//delete

}
