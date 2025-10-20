package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import model.Employee;
import util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	public static void main(String[] args) {
		EmployeeDaoImpl edi=new EmployeeDaoImpl();
		/*Employee em=edi.selectByIdAndPw("admin","admin");
		//System.out.println(em);
		
		System.out.println(em.getId()+"\t"+
							em.getEmployeeid()+"\t"+
							em.getName()+"\t"+
							em.getPassword()+"\t"+
							em.getPhone()+"\t"+
							em.getAddress()+"\t"+
							em.getPermission()+"\t"
							);
		*/
		//System.out.println(edi.addEmployeeid());
		//Employee em=edi.selectByEmployeeid("e00006");
		//System.out.println(em.getName());
		//Employee em=new Employee("e00012","Noah","A134134134","123","0934134134","南投","會計權限","離職");
		
		
		//System.out.println(edi.resetPassword("e00001"));
		/*List<Employee> list = edi.selectSales();
		for(Employee l:list) {
			System.out.println(l.getName());
		}*/
	}

	Connection conn=DbConnection.getDb();
//insert-->新增員工
	public boolean insertEmployee(Employee employee) {
		boolean insertResult=false;
		String sql="insert into employee(employeeid,name,idnumber,password,phone,address,permission,status)"
				+ " values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, employee.getEmployeeid());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getIdnumber());
			ps.setString(4, employee.getPassword());
			ps.setString(5, employee.getPhone());
			ps.setString(6, employee.getAddress());
			ps.setString(7, employee.getPermission());
			ps.setString(8, employee.getStatus());
			ps.executeUpdate();
			insertResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return insertResult;
	}
	
//select-->帳號+密碼-->登入確認
	@Override
	public Employee selectByIdAndPw(String employeeid, String password) {
		Employee employee=null;
		String sql="select * from employee where employeeid=? and password=?";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, employeeid);
			ps.setString(2, password);
			//System.out.println(Debug:employeeid+"\t"+password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				employee=new Employee();
				employee.setId(rs.getInt("id"));
				employee.setEmployeeid(rs.getString("employeeid"));
				employee.setName(rs.getString("name"));
				employee.setIdnumber(rs.getString("idnumber"));
				employee.setPassword(rs.getString("password"));
				employee.setPhone(rs.getString("phone"));
				employee.setAddress(rs.getString("address"));
				employee.setPermission(rs.getString("permission"));
				employee.setStatus(rs.getString("status"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	
//select-->自動新增員編
	public String addEmployeeid() {
		String employeeid="";
		String nextEmployeeid="";
		String sql="select employeeid from employee order by id desc limit 1";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
		
			if (rs.next()) {
				employeeid=rs.getString("employeeid")+"\n";
				//System.out.println(employeeid);
				int num=Integer.parseInt(employeeid.substring(2,6));
				nextEmployeeid = String.format("e%05d",num+1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nextEmployeeid;
	}

//依員工編號篩選
	@Override
	public Employee selectByEmployeeid(String employeeid) {
		Employee employee=null;
		String sql="select * from employee where employeeid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, employeeid);
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
			employee=new Employee();
			employee.setId(rs.getInt("id"));
			employee.setEmployeeid(rs.getString("employeeid"));
			employee.setName(rs.getString("name"));
			employee.setIdnumber(rs.getString("idnumber"));
			employee.setPassword(rs.getString("password"));
			employee.setPhone(rs.getString("phone"));
			employee.setAddress(rs.getString("address"));
			employee.setPermission(rs.getString("permission"));
			employee.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	
	
//select 依指定條件篩選And	
	@Override
	public List<Employee> selectByInput(String employeeid, String name, String idnumber, String phone, String address,
			String permission, String status) {
		List<Employee> list=new ArrayList();
		Employee employee=null;
		StringBuilder sql=new StringBuilder("select * from employee where 1=1");
		if (employeeid != null && !employeeid.isEmpty()) {sql.append(" and employeeid=?");}
		if (name != null && !name.isEmpty()) {sql.append(" and name=?");}
		if (idnumber != null && !idnumber.isEmpty()) {sql.append(" and idnumber=?");}
		if (phone != null && !phone.isEmpty()) {sql.append(" and phone=?");}
		if (address != null && !address.isEmpty()) {sql.append(" and address=?");}
		if (permission != null && !permission.isEmpty()) {sql.append(" and permission=?");}
		if (status != null && !status.isEmpty()) {sql.append(" and status=?");}
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql.toString());
			int index=1;
			if (employeeid != null && !employeeid.isEmpty()) {ps.setString(index, employeeid);	index++;}
			if (name != null && !name.isEmpty()) {ps.setString(index, name);	index++;}
			if (idnumber != null && !idnumber.isEmpty()) {ps.setString(index, idnumber);	index++;}
			if (phone != null && !phone.isEmpty()) {ps.setString(index, phone);	index++;}
			if (address != null && !address.isEmpty()) {ps.setString(index, address);		index++;}
			if (permission != null && !permission.isEmpty()) {ps.setString(index, permission);	index++;}
			if (status != null && !status.isEmpty()) {ps.setString(index, status);	index++;}
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				employee=new Employee();
				employee.setId(rs.getInt("id"));
				employee.setEmployeeid(rs.getString("employeeid"));
				employee.setName(rs.getString("name"));
				employee.setIdnumber(rs.getString("idnumber"));
				employee.setPassword(rs.getString("password"));
				employee.setPhone(rs.getString("phone"));
				employee.setAddress(rs.getString("address"));
				employee.setPermission(rs.getString("permission"));
				employee.setStatus(rs.getString("status"));
				list.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
//update 依照員編修改資料
	@Override
	public boolean updateEmployee(Employee employee) {
		boolean updateResult=false;
		String sql="update employee set name=?, idnumber=?, phone=?, address=?, permission=?, status=? where employeeid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getIdnumber());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getAddress());
			ps.setString(5, employee.getPermission());
			ps.setString(6, employee.getStatus());
			ps.setString(7, employee.getEmployeeid());
			ps.executeUpdate();
			
			updateResult=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateResult;
	}

	@Override
	public boolean resetPassword(String employeeid) {
		String sql="update employee set password=? where employeeid=?";
		boolean resetResult=false;
		Employee employee=selectByEmployeeid(employeeid);
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,employee.getEmployeeid());
			ps.setString(2,employee.getEmployeeid());
			ps.executeUpdate();
			resetResult=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resetResult;
	}

	@Override
	public List<Employee> selectSales() {
		List<Employee> list=new ArrayList();
		Employee employee=null;
		String sql="select * from employee where permission='一般權限' and status='在職'";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
		
			while (rs.next()) {
				employee=new Employee();
				employee.setId(rs.getInt("id"));
				employee.setEmployeeid(rs.getString("employeeid"));
				employee.setName(rs.getString("name"));
				employee.setIdnumber(rs.getString("idnumber"));
				employee.setPassword(rs.getString("password"));
				employee.setPhone(rs.getString("phone"));
				employee.setAddress(rs.getString("address"));
				employee.setPermission(rs.getString("permission"));
				employee.setStatus(rs.getString("status"));
				list.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean updatePassword(String employeeid, String password) {
		String sql="update employee set password=? where employeeid=?";
		boolean resetResult=false;
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2,employeeid);
			ps.executeUpdate();
			resetResult=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resetResult;
	}
	
}
