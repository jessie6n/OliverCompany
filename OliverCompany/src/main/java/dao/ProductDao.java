package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	//create
	
	
	//read
	public List<Product> selectAllProductName();
	public Product selectByProductName(String name);
	
	
	//update
	
	
	//delete

}
