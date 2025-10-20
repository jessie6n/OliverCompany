package model;

public class Oorder {
	private int id;
	private String oorderno;
	private String oorderdate;
	private String memberid;
	private String employeeid;
	private int totalAmount;
	private int discount;
	private int finalAmount;
	private String paymentMethod;
	
	public Oorder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oorder(String oorderno, String oorderdate,String memberid, String employeeid, int totalAmount, int discount, int finalAmount,
			String paymentMethod) {
		super();
		this.oorderno = oorderno;
		this.oorderdate=oorderdate;
		this.memberid = memberid;
		this.employeeid = employeeid;
		this.totalAmount = totalAmount;
		this.discount = discount;
		this.finalAmount = finalAmount;
		this.paymentMethod = paymentMethod;
	}

	public String getOorderdate() {
		return oorderdate;
	}

	public void setOorderdate(String oorderdate) {
		this.oorderdate = oorderdate;
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

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(int finalAmount) {
		this.finalAmount = finalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
