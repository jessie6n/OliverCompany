package vo;

public class OorderView {
	private int id;
	private String oorderno;
	private String date;
	private String memberid;
	private String membername;
	private String employeeid;
	private String employeename;
	private String finalamount;
	
	public OorderView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OorderView(String oorderno, String date, String memberid, String membername, String employeeid,
			String employeename, String finalamount) {
		super();
		this.oorderno = oorderno;
		this.date = date;
		this.memberid = memberid;
		this.membername = membername;
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.finalamount = finalamount;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getFinalamount() {
		return finalamount;
	}

	public void setFinalamount(String finalamount) {
		this.finalamount = finalamount;
	}
	

}
