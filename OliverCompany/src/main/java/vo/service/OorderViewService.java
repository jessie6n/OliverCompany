package vo.service;

import java.util.List;

import vo.OorderView;

public interface OorderViewService {
	
	//select
	public List<OorderView> searchOoderByInput(String oorderno, String datefrom, String dateto, String memberid, String membername, String employeeid,
			String employeename);

}
