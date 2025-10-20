package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CartDao;
import model.Cart;
import util.DbConnection;

public class CartDaoImpl implements CartDao{
	

	public static void main(String[] args) {
		CartDaoImpl cartdi=new CartDaoImpl();
		Cart addcart=new Cart("m00004","p00001",10);
		Cart cart=cartdi.selectByProductnoAndMemberid(addcart);
		cart.setQuantity(cart.getQuantity()+addcart.getQuantity());
		
		if (cart !=null) {
			cartdi.updateQuantity(cart);
		}
	}
	
	Connection conn=DbConnection.getDb();
	@Override
	public boolean addCart(Cart cart) {
		boolean addResult=false;
		String sql="insert into cart(memberid, productno, quantity) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, cart.getMemberid());
			ps.setString(2, cart.getProductno());
			ps.setInt(3, cart.getQuantity());
			ps.executeUpdate();
			addResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addResult;
	}
	
	@Override
	public Cart selectByProductnoAndMemberid(Cart addcart) {
		Cart cart=null;
		String sql="select * from cart where productno=? and memberid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, addcart.getProductno());
			ps.setString(2, addcart.getMemberid());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cart=new Cart();
				cart.setId(rs.getInt("id"));
				cart.setMemberid(rs.getString("memberid"));
				cart.setProductno(rs.getString("productno"));
				cart.setQuantity(rs.getInt("quantity"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
	}
	
	@Override
	public List<Cart> selectByMemberid(String memberid) {
		List<Cart> list=new ArrayList();
		Cart cart=null;
		String sql="select * from cart where memberid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, memberid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cart=new Cart();
				cart.setId(rs.getInt("id"));
				cart.setMemberid(rs.getString("memberid"));
				cart.setProductno(rs.getString("productno"));
				cart.setQuantity(rs.getInt("quantity"));
				list.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public boolean updateQuantity(Cart cart) {
		boolean updateResult=false;
		String sql="update cart set quantity=? where productno=? and memberid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, cart.getQuantity());
			ps.setString(2, cart.getProductno());
			ps.setString(3, cart.getMemberid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateResult;
	}

	@Override
	public boolean deleteCart(int id) {
		boolean deleteResult=false;
		String sql="delete from cart where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			deleteResult=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deleteResult;
	}


}
