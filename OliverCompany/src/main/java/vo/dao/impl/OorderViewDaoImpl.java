package vo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbConnection;
import vo.OorderView;
import vo.dao.OorderViewDao;

public class OorderViewDaoImpl implements OorderViewDao {

	public static void main(String[] args) {
		OorderViewDaoImpl ovdi=new OorderViewDaoImpl();
				List<OorderView> list=ovdi.searchOoderByInput(null, null, "2025-10-16", null, null, null, null);
				for(OorderView o:list) {
					System.out.println(o.getOorderno());
				}
	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public List<OorderView> searchOoderByInput(String oorderno, String datefrom, String dateto, String memberid, String membername,
			String employeeid, String employeename) {
		List<OorderView> list=new ArrayList();
		OorderView oov=null;
		StringBuilder sql=new StringBuilder("select * from oorder_view where 1=1");
		if(oorderno!=null && !oorderno.isBlank()) {sql.append(" and oorderno=?");} 
		
		/*if(datefrom!=null && !datefrom.isBlank()){
			if (dateto!=null && !dateto.isBlank()) {
				sql.append(" and date(oorderdate) between ? and ?");	}
			else {sql.append(" and date(oorderdate) >= ?");}
		} else {
			if (dateto!=null && !dateto.isBlank()) {
				sql.append(" and date(oorderdate) <= ?");}
		}*/
		
		if(datefrom!=null && !datefrom.isBlank()){
			if (dateto!=null && !dateto.isBlank()) {
				sql.append(" and oorderdate between ? and ?");	}
			else {sql.append(" and oorderdate >= ?");}
		} else {
			if (dateto!=null && !dateto.isBlank()) {
				sql.append(" and oorderdate <= ?");}
		}
		
		if(memberid!=null && !memberid.isBlank()) {sql.append(" and memberid=?");} 
		if(membername!=null && !membername.isBlank()) {sql.append(" and membername=?");} 
		if(employeeid!=null && !employeeid.isBlank()) {sql.append(" and employeeid=?");} 
		if(employeename!=null && !employeename.isBlank()) {sql.append(" and employeename=?");} 
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql.toString());
			int index=1;
			if(oorderno!=null && !oorderno.isBlank()) {ps.setString(index, oorderno); index++;}
			
			if(datefrom!=null && !datefrom.isBlank()) {datefrom=datefrom + " 00:00:00";}
			if(dateto!=null && !dateto.isBlank()) {dateto=dateto+" 23:59:59";}
			if(datefrom!=null && !datefrom.isBlank()){
				if (dateto!=null && !dateto.isBlank()) {
					ps.setString(index, datefrom); index++;
					ps.setString(index, dateto); index++;
				} else {ps.setString(index, datefrom); index++;}
			} else {
				if (dateto!=null && !dateto.isBlank()) {
					ps.setString(index, dateto); index++;}
			}
			
			if(memberid!=null && !memberid.isBlank()) {ps.setString(index, memberid); index++;}
			if(membername!=null && !membername.isBlank()) {ps.setString(index, membername); index++;} 
			if(employeeid!=null && !employeeid.isBlank()) {ps.setString(index, employeeid); index++;}
			if(employeename!=null && !employeename.isBlank()) {ps.setString(index, employeename); index++;}
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				oov=new OorderView();
				oov.setId(rs.getInt("id"));
				oov.setOorderno(rs.getString("oorderno"));
				oov.setDate(rs.getString("oorderdate"));
				oov.setMemberid(rs.getString("memberid"));
				oov.setMembername(rs.getString("membername"));
				oov.setEmployeeid(rs.getString("employeeid"));
				oov.setEmployeename(rs.getString("employeename"));
				oov.setFinalamount(rs.getString("finalamount"));

				list.add(oov);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
