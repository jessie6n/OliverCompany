package service;

import java.util.List;

import model.Cart;

public interface CartService {

	//create
	public boolean addCart(Cart cart);
	
	
	//read
	public Cart selectByProductnoAndMemberid(Cart addcart);
	public List<Cart> selectByMemberid(String memberid);
	
	
	//update
	public boolean updateQuantity(Cart cart);
	
	
	//delete
	public boolean deleteCart(int id);
}
