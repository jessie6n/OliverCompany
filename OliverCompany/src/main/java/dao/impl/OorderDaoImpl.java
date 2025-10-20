package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.OorderDao;
import model.Oorder;
import util.DbConnection;

public class OorderDaoImpl implements OorderDao {

	public static void main(String[] args) {
		OorderDaoImpl odi=new OorderDaoImpl();
	}

	Connection conn=DbConnection.getDb();
	
	//新增訂單
	@Override
	public boolean insertOrder(Oorder oorder) {
		boolean insertResult=false;
		String sql="insert into oorder(oorderno,oorderdate,memberid,employeeid,totalamount,discount,finalamount,paymentmethod)"
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, oorder.getOorderno());
			ps.setString(2, oorder.getOorderdate());
			ps.setString(3, oorder.getMemberid());
			ps.setString(4, oorder.getEmployeeid());
			ps.setInt(5, oorder.getTotalAmount());
			ps.setInt(6, oorder.getDiscount());
			ps.setInt(7, oorder.getFinalAmount());
			ps.setString(8, oorder.getPaymentMethod());
			ps.executeUpdate();
			insertResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return insertResult;
	}
	
	//select-依上一筆訂單編號下一筆訂單編號
	public String getNextOorderNo(){
		String oorderNo="";
		String nextOorderNo="";
		String sql="select oorderno from oorder order by id desc limit 1";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				oorderNo=rs.getString("oorderno");
				int num=Integer.parseInt(oorderNo.substring(2, 6));
				nextOorderNo=String.format("o%05d",num+1);
			} else {
				nextOorderNo="o00001";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nextOorderNo;
	}
	

}
