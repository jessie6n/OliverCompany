package service.impl;

import dao.impl.OorderDetailDaoImpl;
import model.OorderDetail;
import service.OorderDetailService;

public class OorderDetailServiceImpl implements OorderDetailService{

	public static void main(String[] args) {

	}
	
	OorderDetailDaoImpl oddi=new OorderDetailDaoImpl();

	@Override
	public void insertOorderDetail(OorderDetail oodetail) {
		oddi.insertOorderDetail(oodetail);
	}

	@Override
	public int getNextOorderDetailNo() {
			int nextNo=oddi.getNextOorderDetailNo();
		return nextNo;
	}

}
