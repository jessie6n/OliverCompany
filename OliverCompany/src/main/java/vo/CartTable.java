package vo;

public class CartTable {
	private int id;
	private String memberid;
	private String productno;
	private int quantity;
	private String productname;
	private String chi_name;
	private int price;
	private String category;
	private int sum;
	
	public CartTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartTable(String memberid, String productno, int quantity, String productname, String chi_name, int price,
			String category, int sum) {
		super();
		this.memberid = memberid;
		this.productno = productno;
		this.quantity = quantity;
		this.productname = productname;
		this.chi_name = chi_name;
		this.price = price;
		this.category = category;
		this.sum = sum;
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

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
