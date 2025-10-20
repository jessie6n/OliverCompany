package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.OorderDetailDao;
import model.OorderDetail;
import util.DbConnection;

public class OorderDetailDaoImpl implements OorderDetailDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public void insertOorderDetail(OorderDetail oodetail) {
		String sql="insert into oorderdetail(oorderno, oorderdetailno, productno, quantity)"
				+ " values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, oodetail.getOorderno());
			ps.setInt(2, oodetail.getOorderdetailno());
			ps.setString(3, oodetail.getProductno());
			ps.setInt(4, oodetail.getQuantity());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int getNextOorderDetailNo() {
		String sql="select oorderdetailno from oorderdetail order by id desc limit 1";
		int num=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				num=rs.getInt("oorderdetailno");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num+1;
	}

}
