package vo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbConnection;
import vo.CartTable;
import vo.dao.CartTableDao;

public class CartTableDaoImpl implements CartTableDao {

	public static void main(String[] args) {
		CartTableDaoImpl ctdi=new CartTableDaoImpl();
		List<CartTable> list=ctdi.cartViewByMemberid("m00004");
		for(CartTable ct:list) {
			System.out.println("商品名稱:"+ct.getChi_name()+
					"\t數量:"+ct.getQuantity());
		}

	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public List<CartTable> cartViewByMemberid(String memberid) {
		List<CartTable> list=new ArrayList();
		CartTable carttable=null;
		String sql="select * from cart_view where memberid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, memberid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				carttable=new CartTable();
				carttable.setId(rs.getInt("id"));
				carttable.setMemberid(rs.getString("memberid"));
				carttable.setProductno(rs.getString("productno"));
				carttable.setQuantity(rs.getInt("quantity"));
				carttable.setProductname(rs.getString("productname"));
				carttable.setChi_name(rs.getString("chi_name"));
				carttable.setPrice(rs.getInt("price"));
				carttable.setCategory(rs.getString("category"));
				carttable.setSum(rs.getInt("sum"));
				
				list.add(carttable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<CartTable> getCartIdByMemberidAndChi_name(String memberid, String chi_name) {
		List<CartTable> list=new ArrayList();
		CartTable carttable=null;
		String sql="select * from cart_view where memberid=? and chi_name=?";
		try {
			conn=DbConnection.getDb();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, memberid);
			ps.setString(2, chi_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				carttable=new CartTable();
				carttable.setId(rs.getInt("id"));
				carttable.setMemberid(rs.getString("memberid"));
				carttable.setProductno(rs.getString("productno"));
				carttable.setQuantity(rs.getInt("quantity"));
				carttable.setProductname(rs.getString("productname"));
				carttable.setChi_name(rs.getString("chi_name"));
				carttable.setPrice(rs.getInt("price"));
				carttable.setCategory(rs.getString("category"));
				carttable.setSum(rs.getInt("sum"));
				
				list.add(carttable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
