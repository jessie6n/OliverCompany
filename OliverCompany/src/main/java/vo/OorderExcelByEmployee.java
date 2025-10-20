package vo;

public class OorderExcelByEmployee {
	private String oorderNo;
	private String oorderDate;
	private String memberId;
	private String memberName;
	private String productName;
	private int price;
	private int quantity;
	private int subTotal;
	private int totalAmount;
	private int discount;
	private int finalAmount;
	private String paymentMethod;
	
	public String getOorderNo() {
		return oorderNo;
	}
	public void setOorderNo(String oorderNo) {
		this.oorderNo = oorderNo;
	}
	public String getOorderDate() {
		return oorderDate;
	}
	public void setOorderDate(String oorderDate) {
		this.oorderDate = oorderDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
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
