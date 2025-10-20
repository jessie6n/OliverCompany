package vo.service.impl;

import java.util.List;

import vo.CartTable;
import vo.dao.impl.CartTableDaoImpl;
import vo.service.CartTableService;

public class CartTableServiceImpl implements CartTableService{
	CartTableDaoImpl ctdi=new CartTableDaoImpl();

	public static void main(String[] args) {

	}

	@Override
	public List<CartTable> cartViewByMemberid(String memberid) {
		List<CartTable> list=ctdi.cartViewByMemberid(memberid);
		return list;
	}

	@Override
	public List<CartTable> getCartIdByMemberidAndChi_name(String memberid, String chi_name) {
		List<CartTable> list=ctdi.getCartIdByMemberidAndChi_name(memberid, chi_name);
		return list;
	}

}
