package model;

public class Cart {
	private int id;
	private String memberid;
	private String productno;
	private int quantity;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String memberid, String productno, int quantity) {
		super();
		this.memberid = memberid;
		this.productno = productno;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getProductno() {
		return productno;
	}

	public void setProductno(String productno) {
		this.productno = productno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
