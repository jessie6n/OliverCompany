package vo.service;

import java.util.List;

import vo.DetailView;

public interface DetailViewService {

	//select
	//依訂單編號查詢訂單明細
	public List<DetailView> selectDetailByOorderNo(String oorderno);
	
}
