package vo.service.impl;

import java.util.List;

import vo.OorderExcelByEmployee;
import vo.dao.impl.OorderExcelByEmployeeDaoImpl;
import vo.service.OorderExcelByEmployeeService;

public class OorderExcelByEmployeeServiceImpl implements OorderExcelByEmployeeService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	OorderExcelByEmployeeDaoImpl oebedi=new OorderExcelByEmployeeDaoImpl();

	@Override
	public List<OorderExcelByEmployee> outputOorder(String oorderno) {
		List<OorderExcelByEmployee> list=oebedi.outputOorder(oorderno);
		return list;
	}
}
