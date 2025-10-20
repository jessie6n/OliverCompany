package service.impl;

import dao.impl.OorderDaoImpl;
import model.Oorder;
import service.OorderService;

public class OorderServiceImpl implements OorderService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	OorderDaoImpl odi=new OorderDaoImpl();
	
	@Override
	public boolean insertOrder(Oorder oorder) {
		return odi.insertOrder(oorder);
	}

	@Override
	public String getNextOorderNo() {
		return odi.getNextOorderNo();
	}

}
