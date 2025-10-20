package vo.dao;

import java.util.List;

import vo.CartTable;

public interface CartTableDao {
	
	//vo只限read
	public List<CartTable> cartViewByMemberid(String memberid);
	public List<CartTable> getCartIdByMemberidAndChi_name(String memberid,String chi_name);

}
