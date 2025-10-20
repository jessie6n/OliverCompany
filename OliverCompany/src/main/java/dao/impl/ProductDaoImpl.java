package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import model.Product;
import util.DbConnection;

public class ProductDaoImpl implements ProductDao {

	public static void main(String[] args) {
		ProductDaoImpl pdi=new ProductDaoImpl();
		
		/*List<Product> list=pdi.selectAllProductName();
		for(Product pd:list) {
			System.out.println(pd.getName());
		}*/
		
		/*Product pd=pdi.selectByProductName("orange");
		System.out.println(pd.getProductno()+"\t"+pd.getName());*/

	}

		Connection conn=DbConnection.getDb();
		
	@Override
	public List<Product> selectAllProductName() {
		List<Product> list=new ArrayList();
		String sql="select * from product";
		Product pd=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				pd=new Product();
				pd.setId(rs.getInt("id"));
				pd.setProductno(rs.getString("productno"));
				pd.setName(rs.getString("name"));
				pd.setChi_name(rs.getString("chi_name"));
				pd.setPrice(rs.getInt("price"));
				pd.setCategory(rs.getString("category"));
				list.add(pd);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Product selectByProductName(String name) {
		Product pd=null;
		String sql="select * from product where name=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				pd=new Product();
				pd.setId(rs.getInt("id"));
				pd.setProductno(rs.getString("productno"));
				pd.setName(rs.getString("name"));
				pd.setChi_name(rs.getString("chi_name"));
				pd.setPrice(rs.getInt("price"));
				pd.setCategory(rs.getString("category"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pd;
	}

}
