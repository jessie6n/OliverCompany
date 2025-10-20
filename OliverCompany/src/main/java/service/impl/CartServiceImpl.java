package service.impl;

import java.util.List;

import dao.impl.CartDaoImpl;
import model.Cart;
import service.CartService;

public class CartServiceImpl implements CartService {
	
	CartDaoImpl cdi=new CartDaoImpl();

	public static void main(String[] args) {

	}

	@Override
	public boolean addCart(Cart cart) {
		boolean addResult=cdi.addCart(cart);
		return addResult;
	}

	@Override
	public Cart selectByProductnoAndMemberid(Cart addcart) {
		Cart cart=cdi.selectByProductnoAndMemberid(addcart);
		return cart;
	}

	@Override
	public boolean updateQuantity(Cart cart) {
		boolean updateResult=cdi.updateQuantity(cart);
		return updateResult;
	}

	@Override
	public List<Cart> selectByMemberid(String memberid) {
		List<Cart> list=cdi.selectByMemberid(memberid);
		return list;
	}

	@Override
	public boolean deleteCart(int id) {
		boolean deleteResult=cdi.deleteCart(id);
		return deleteResult;
	}

}
