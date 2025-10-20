package dao;

import model.OorderDetail;

public interface OorderDetailDao {
	
	//create
	//新增訂單明細
	public void insertOorderDetail(OorderDetail oodetail);
	
	
	//read
	//產生明細編號
	public int getNextOorderDetailNo();
	
	
	//update
	
	
	//delete

}
