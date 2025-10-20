package service.impl;

import java.util.List;

import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDaoImpl pdi=new ProductDaoImpl();

	public static void main(String[] args) {
		

	}

	@Override
	public List<Product> selectAllProductName() {
		List<Product> list=pdi.selectAllProductName();
		return list;
	}

	@Override
	public Product selectByProductName(String name) {
		Product pd=pdi.selectByProductName(name);
		return pd;
	}

	
	
}
