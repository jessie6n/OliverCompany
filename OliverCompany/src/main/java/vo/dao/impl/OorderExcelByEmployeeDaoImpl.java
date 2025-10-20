package vo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbConnection;
import vo.OorderExcelByEmployee;
import vo.dao.OorderExcelByEmployeeDao;

public class OorderExcelByEmployeeDaoImpl implements OorderExcelByEmployeeDao{

	public static void main(String[] args) {
		OorderExcelByEmployeeDaoImpl oebedi=new OorderExcelByEmployeeDaoImpl();
		for(OorderExcelByEmployee o:oebedi.outputOorder("o00006")) {
			System.out.println(o.getOorderNo()+"\t"+o.getProductName());
		}
		
		
	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public List<OorderExcelByEmployee> outputOorder(String oorderno) {
		List<OorderExcelByEmployee> list=new ArrayList();
		OorderExcelByEmployee oebe=null;
		String sql="select * from oorderexcelbyemployee_view where oorderno=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, oorderno);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				oebe=new OorderExcelByEmployee();
				oebe.setOorderNo(rs.getString("oorderno"));
				oebe.setOorderDate(rs.getString("oorderdate"));
				oebe.setMemberId(rs.getString("memberid"));
				oebe.setMemberName(rs.getString("membername"));
				oebe.setProductName(rs.getString("productname"));
				oebe.setPrice(rs.getInt("price"));
				oebe.setQuantity(rs.getInt("quantity"));
				oebe.setSubTotal(rs.getInt("subtotal"));
				oebe.setTotalAmount(rs.getInt("totalamount"));
				oebe.setDiscount(rs.getInt("discount"));
				oebe.setFinalAmount(rs.getInt("finalamount"));
				oebe.setPaymentMethod(rs.getString("paymentmethod"));
				
				list.add(oebe);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
