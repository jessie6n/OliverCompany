package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		
		MemberDaoImpl mdi=new MemberDaoImpl();
		
	//select 查詢全部
		//System.out.println(new MemberDaoImpl().selectAll());
		//System.out.println(new MemberDaoImpl().addMemberid());
		//Member m=new Member(null,"alec","alec","alec","0927272272","男",null,"台北");
		//mdi.insert(m);
		
		/*List<Member> m=mdi.selectMemberByInput(null, null, null, null, null);
		for(Member o:m) {
			System.out.println(o.getName());
		}*/
		Member m=mdi.selectByMemberid("m00001");
		System.out.println(m.getName());
		
	}

	private Connection conn=DbConnection.getDb();
	
//insert-inject
	@Override
	public boolean insert(Member member) {
		boolean insertResult=false;
		String sql="insert into member(memberid,username,password,name,phone,sex,birthday,address) "
				+ "values(?,?,?,?,?,?,?,?)";
	
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, addMemberid());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getName());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getSex());
			ps.setString(7, member.getBirthday());		
			ps.setString(8, member.getAddress());
			ps.executeUpdate();
			insertResult=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}

		
		
//select
	@Override
	public String selectAll() {
		String sql="select * from member";
		String show="";
		PreparedStatement ps;
		
		try {
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				show=show+"會員號碼:"+rs.getString("memberid")+
						"\t帳號"+rs.getString("username")+
						"\t密碼"+rs.getString("password")+
						"\t姓名:"+rs.getString("name")+
						"\t電話:"+rs.getString("phone")+
						"\t性別:"+rs.getString("sex")+
						"\t生日:"+rs.getString("address")+
						"\t地址:"+rs.getString("address")+"\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return show;
	}
	
//select-->註冊會員-->確認帳號是否重複
	@Override
	public boolean checkUsername(String username) {
		String sql="select * from member where username=?";
		boolean result=false;
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				result=true;
			};

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
//select-->登入帳號密碼正確
	@Override
	public Member checkUsernameAndPassword(String username, String password) {
		String sql="select * from member where username=? and password=?";
		Member member=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				member=new Member();
				member.setMemberid(rs.getString("memberid"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setSex(rs.getString("sex"));
				member.setBirthday(rs.getString("birthday"));
				member.setAddress(rs.getString("address"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	//select-->註冊會員-->確認帳號是否重複
		@Override
		public String checkMemberid(String memberid) {
			String sql="select * from member where memberid=?";
			String result="";
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, memberid);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					result=rs.getString("name");
				};
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
		public String addMemberid() {
			String memberid="";
			String nextMemberid="";
			String sql="select memberid from member order by id desc limit 1";
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
			
				if (rs.next()) {
					memberid=rs.getString("memberid")+"\n";
					//System.out.println(employeeid);
					int num=Integer.parseInt(memberid.substring(2,6));
					nextMemberid = String.format("m%05d",num+1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return nextMemberid;
		}
		
//select 查詢會員資料
		@Override
		public List<Member> selectMemberByInput(String memberid, String name, String address, String sex, String birthday) {
			StringBuilder sql=new StringBuilder("select * from member where 1=1");
			List<Member> list=new ArrayList();
			Member m=null;
			
			if (memberid !=null && !memberid.isEmpty()) {sql.append(" and memberid=?");}
			if (name !=null && !name.isEmpty()) {sql.append(" and name=?");}
			if (address !=null && !address.isEmpty()) {sql.append(" and address=?");}
			if (sex !=null && !sex.isEmpty()) {sql.append(" and sex=?");}
			if (birthday !=null && !birthday.isEmpty()) {sql.append(" and birthday=?");}
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql.toString());
				
				int index=1;
				if (memberid !=null && !memberid.isEmpty()) {ps.setString(index, memberid);	index++;}
				if (name !=null && !name.isEmpty()) {ps.setString(index, name); index++;}
				if (address !=null && !address.isEmpty()) {ps.setString(index, address); index++;}
				if (sex !=null && !sex.isEmpty()) {ps.setString(index, sex); index++;}
				if (birthday !=null && !birthday.isEmpty()) {ps.setString(index, birthday);; index++;}
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					m=new Member();
					m.setId(rs.getInt("id"));
					m.setMemberid(rs.getString("memberid"));
					m.setUsername(rs.getString("username"));
					m.setPassword(rs.getString("password"));
					m.setName(rs.getString("name"));
					m.setPhone(rs.getString("phone"));
					m.setAddress(rs.getString("address"));
					m.setSex(rs.getString("sex"));
					m.setBirthday(rs.getString("Birthday"));					
					list.add(m);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		
//依會員編號查詢
		@Override
		public Member selectByMemberid(String memberid) {
			Member m=null;
			String sql="select * from member where memberid=?";
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, memberid);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					m=new Member();
					m.setId(rs.getInt("id"));
					m.setMemberid(rs.getString("memberid"));
					m.setUsername(rs.getString("username"));
					m.setPassword(rs.getString("password"));
					m.setName(rs.getString("name"));
					m.setPhone(rs.getString("phone"));
					m.setAddress(rs.getString("address"));
					m.setSex(rs.getString("sex"));
					m.setBirthday(rs.getString("Birthday"));		
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return m;
		}

//update
	@Override
	public void update(String name, String password, int memberid) {
		String sql="update member set name=?, password=? where memberid=?";
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, password);
			ps.setInt(3, memberid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean delete(String memberid) {
		String sql="delete from member where memberid=?";
		boolean deleteResult=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, memberid);
			ps.executeUpdate();
			deleteResult = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deleteResult;
	}

}
