package dao;

import java.util.List;

import model.Cart;

public interface CartDao {
	
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
