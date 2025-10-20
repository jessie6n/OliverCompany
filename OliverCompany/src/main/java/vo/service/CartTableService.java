package vo.service;

import java.util.List;

import vo.CartTable;

public interface CartTableService {
	
	//vo只限read
	public List<CartTable> cartViewByMemberid(String memberid);
	public List<CartTable> getCartIdByMemberidAndChi_name(String memberid,String chi_name);
	
}
