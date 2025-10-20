package vo.service.impl;

import java.util.List;

import vo.DetailView;
import vo.dao.impl.DetailViewDaoImpl;
import vo.service.DetailViewService;

public class DetailViewServiceImpl implements DetailViewService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	DetailViewDaoImpl dvdi=new DetailViewDaoImpl();
	
	@Override
	public List<DetailView> selectDetailByOorderNo(String oorderno) {
		List<DetailView> dv= dvdi.selectDetailByOorderNo(oorderno);
		return dv;
	}

	
}
