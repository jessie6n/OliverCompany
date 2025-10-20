package vo.dao;

import java.util.List;

import vo.OorderExcelByEmployee;

public interface OorderExcelByEmployeeDao {
	
	//select 依訂單編號調閱訂單內容
	public List<OorderExcelByEmployee> outputOorder(String oorderno);

}
