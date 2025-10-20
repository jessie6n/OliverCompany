package service.impl;

import java.util.List;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	public static void main(String[] args) {
		EmployeeServiceImpl esi=new EmployeeServiceImpl();
		System.out.println(esi.employeeLogin("admin","admin"));
		
	}
	
	EmployeeDaoImpl edi=new EmployeeDaoImpl();
	
	public Employee employeeLogin(String employeeid, String password) {
		Employee employee=edi.selectByIdAndPw(employeeid, password);
		return employee;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		boolean addResult = edi.insertEmployee(employee);
		return addResult;
	}

	@Override
	public Employee selectByEmployeeid(String employeeid) {
		Employee employee = edi.selectByEmployeeid(employeeid);
		return employee;
	}
	
	@Override
	public List<Employee> selectByInput(String employeeid, String name, String idnumber, String phone, String address,
			String permission, String status) {
		List<Employee> list=edi.selectByInput(employeeid, name, idnumber, phone, address, permission, status);
		return list;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		boolean updateResult = edi.updateEmployee(employee);
		
		return updateResult;
	}

	@Override
	public boolean resetPassword(String employeeid) {
		boolean resetResult = edi.resetPassword(employeeid);
		return resetResult;
	}

	@Override
	public List<Employee> selectSales() {
		List<Employee> list=edi.selectSales();
		return list;
	}

	@Override
	public boolean updatePassword(String employeeid, String password) {
		boolean updateResult = edi.updatePassword(employeeid,password);
		return updateResult;
	}

}
