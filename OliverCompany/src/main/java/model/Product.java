package model;

public class Product {
	private int id;
	private String productno;
	private String name;
	private String chi_name;
	private int price;
	private String category;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productno, String name, String chi_name, int price, String category) {
		super();
		this.productno = productno;
		this.name = name;
		this.chi_name = chi_name;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductno() {
		return productno;
	}

	public void setProductno(String productno) {
		this.productno = productno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChi_name() {
		return chi_name;
	}

	public void setChi_name(String chi_name) {
		this.chi_name = chi_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
