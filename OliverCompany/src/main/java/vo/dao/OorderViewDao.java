package vo.dao;

import java.util.List;

import vo.OorderView;

public interface OorderViewDao {
	
	//select
	public List<OorderView> searchOoderByInput(String oorderno, String datefrom, String dateto, String memberid, String membername, String employeeid,
			String employeename);
	

}
