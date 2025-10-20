package vo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.DbConnection;
import vo.DetailView;
import vo.dao.DetailViewDao;

public class DetailViewDaoImpl implements DetailViewDao {

	public static void main(String[] args) {
		DetailViewDaoImpl dvdi=new DetailViewDaoImpl();
		dvdi.selectDetailByOorderNo(null);
		
		for(DetailView o:dvdi.selectDetailByOorderNo(null)) {
			System.out.println(o.getProductname()+"\n");
		}

		

	}
	
	Connection conn=DbConnection.getDb();
	
	@Override
	public List<DetailView> selectDetailByOorderNo(String oorderno) {
		List<DetailView> list=new ArrayList();
		DetailView dv;
		String sql="select * from detail_view where oorderno=?";
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, oorderno);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				dv=new DetailView();
				dv.setOorderdetailno(rs.getInt("oorderdetailno"));
				dv.setOorderno(rs.getString("oorderno"));
				dv.setProductno(rs.getString("productno"));
				dv.setProductname(rs.getString("productname"));
				dv.setPrice(rs.getInt("price"));
				dv.setQuantity(rs.getInt("quantity"));
				dv.setSubtotal(rs.getInt("subtotal"));
				
				list.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
