package service;

import java.util.List;

import model.Product;

public interface ProductService {
	//create
	
	
	//read
	public List<Product> selectAllProductName();
	public Product selectByProductName(String name);

	//update
	
	
	//delete
}
