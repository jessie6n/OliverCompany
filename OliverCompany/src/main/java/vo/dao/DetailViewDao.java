package vo.dao;

import java.util.List;

import vo.DetailView;


public interface DetailViewDao {
	
	//select
	//依訂單編號查詢訂單明細
	public List<DetailView> selectDetailByOorderNo(String oorderno);

}
