package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
//create
	//public void insert(String username, String password, String name,String phone,String sex,String birthday,String address);
	public boolean insert(Member member);
	
	
//read
	//全部查詢
	public String selectAll();
	
	//註冊會員-->確認帳號是否重複
	public boolean checkUsername(String username);
	public String checkMemberid(String memberid);
	
	//登入會員
	public Member checkUsernameAndPassword(String username,String password);
	
	//新增會員編號
	public String addMemberid();
	
	//查詢會員資料
	public List<Member> selectMemberByInput(String memberid, String name, String address,String sex,String birthday);
	public Member selectByMemberid(String memberid);
	
	
//update
	public void update(String name,String password,int memberid);
	
	
//delete
	public boolean delete(String memberid);
	

}
