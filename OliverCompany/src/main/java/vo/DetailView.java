package vo;

public class DetailView {
	private int oorderdetailno;
	private String oorderno;
	private String productno;
	private String productname;
	private int price;
	private int quantity;
	private int subtotal;
	
	public DetailView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailView(int oorderdetailno, String oorderno, String productno, String productname, int price,
			int quantity, int subtotal) {
		super();
		this.oorderdetailno = oorderdetailno;
		this.oorderno = oorderno;
		this.productno = productno;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public int getOorderdetailno() {
		return oorderdetailno;
	}

	public void setOorderdetailno(int oorderdetailno) {
		this.oorderdetailno = oorderdetailno;
	}

	public String getOorderno() {
		return oorderno;
	}

	public void setOorderno(String oorderno) {
		this.oorderno = oorderno;
	}

	public String getProductno() {
		return productno;
	}

	public void setProductno(String productno) {
		this.productno = productno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

}
