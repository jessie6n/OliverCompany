package service;

import java.util.List;

import model.Member;

public interface MemberService {
	//create
	//新增會員
	public boolean addMember(Member member);
	
	//read
	//登入會員
	public Member login(String name,String username);
	//新增會員
	public String orderGetName(String memberid); 
	//查詢會員資料
	public List<Member> selectMemberByInput(String memberid, String name, String address,String sex,String birthday);
	public Member selectByMemberid(String memberid);
		

	
	
	//update
	
	
	//delete
	public boolean delete(String memberid);
	

}
