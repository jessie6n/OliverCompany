package vo.service.impl;

import java.util.List;

import vo.OorderView;
import vo.dao.impl.OorderViewDaoImpl;
import vo.service.OorderViewService;

public class OorderViewServiceImpl implements OorderViewService {

	public static void main(String[] args) {
		OorderViewServiceImpl ovsi=new OorderViewServiceImpl();
		List<OorderView> list=ovsi.searchOoderByInput(null, null, null, null, null, null, null);
		for(OorderView o:list) {
			System.out.println(o.getOorderno());
		}
	}
	
	OorderViewDaoImpl ovdi=new OorderViewDaoImpl();

	@Override
	public List<OorderView> searchOoderByInput(String oorderno, String datefrom, String dateto, String memberid,
			String membername, String employeeid, String employeename) {
		List<OorderView> list=
				ovdi.searchOoderByInput(oorderno, datefrom, dateto, memberid, membername, employeeid, employeename);
		return list;
	}

}
