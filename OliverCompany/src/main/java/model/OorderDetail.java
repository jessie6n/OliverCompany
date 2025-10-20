package model;

public class OorderDetail {
	private int id;
	private String oorderno;
	private int oorderdetailno;
	private String productno;
	private int quantity;
	
	public OorderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OorderDetail(String oorderno, int oorderdetailno, String productno, int quantity) {
		super();
		this.oorderno = oorderno;
		this.oorderdetailno = oorderdetailno;
		this.productno = productno;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOorderno() {
		return oorderno;
	}

	public void setOorderno(String oorderno) {
		this.oorderno = oorderno;
	}

	public int getOorderdetailno() {
		return oorderdetailno;
	}

	public void setOorderdetailno(int oorderdetailno) {
		this.oorderdetailno = oorderdetailno;
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
