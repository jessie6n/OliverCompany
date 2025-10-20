package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	public static void main(String[] args) {
		MemberServiceImpl msi=new MemberServiceImpl();
		
		//測試註冊-->帳號重複
		//Member m=new Member("rita888","tina888","tina","0956567567","女","1992/05/01","樹林");
		//System.out.println(msi.addMember(m));
		
		
		//登入測試
		//System.out.println(msi.login("lisa5678","lisa55667788"));

	}
	
	MemberDaoImpl mdi=new MemberDaoImpl();

	@Override
	public boolean addMember(Member member) {
		boolean result=false;
		if(mdi.checkUsername(member.getUsername())) {
			result=true;
		} /*else {
			mdi.insert(member);
		}*/
		return result;	
	}

//會員登入
	@Override
	public Member login(String username, String password) {
		Member member=mdi.checkUsernameAndPassword(username,password);
		return member;
	}

//會員ID查詢名字
	@Override
	public String orderGetName(String memberid) {
		String memberName=mdi.checkMemberid(memberid);
		return memberName;
	}

	
	@Override
	public List<Member> selectMemberByInput(String memberid, String name, String address, String sex, String birthday) {
		List<Member> list=mdi.selectMemberByInput(memberid, name, address, sex, birthday);
		return list;
	}

	@Override
	public Member selectByMemberid(String memberid) {
		Member member=mdi.selectByMemberid(memberid);
		return member;
	}

	@Override
	public boolean delete(String memberid) {
		boolean deleteResult=mdi.delete(memberid);
		return deleteResult;
	}
	
}
