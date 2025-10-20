package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import model.Employee;
import model.Member;
import vo.OorderExcelByEmployee;
import vo.service.impl.OorderExcelByEmployeeServiceImpl;

public class Tool {

	public static void main(String[] args) {
		OorderExcelByEmployeeServiceImpl oebesi=new OorderExcelByEmployeeServiceImpl();
		List<OorderExcelByEmployee> oebe=oebesi.outputOorder("o00013");
		Tool.createOrderDetailExcel(oebe);
		System.out.println(oebe.size());
	}
	
	
//Employee員工資料儲存-->呈現在登入後頁面
	public static void saveEmployee(Employee employee) {
		try {
			FileOutputStream fos=new FileOutputStream("employeelogin.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(employee);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Employee readEmployee() {
		Employee employee=null;
		try {
			FileInputStream fis=new FileInputStream("employeelogin.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			employee=(Employee) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	
//Member會員資料儲存-->呈現在登入後頁面
	public static void saveMember(Member member) {
		try {
			FileOutputStream fos=new FileOutputStream("memberlogin.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(member);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Member readMember() {
		Member member=null;
		try {
			FileInputStream fis=new FileInputStream("memberlogin.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			member=(Member) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
//excel匯出檔案
	public static void createOrderDetailExcel(List<OorderExcelByEmployee> oebe) {	
		try {
			FileOutputStream fos=new FileOutputStream(LocalDate.now()+oebe.get(0).getOorderNo()+oebe.get(0).getMemberName()+".xls");
			HSSFWorkbook excelbook=new HSSFWorkbook();
			HSSFSheet sheet=excelbook.createSheet(oebe.get(0).getOorderNo());
			
			HSSFRow row5=sheet.createRow(5);
			row5.createCell(1).setCellValue("會員編號");
			row5.createCell(2).setCellValue(oebe.get(0).getMemberId());
			row5.createCell(5).setCellValue("訂單編號");
			row5.createCell(6).setCellValue(oebe.get(0).getOorderNo());
			
			HSSFRow row6=sheet.createRow(6);
			row6.createCell(1).setCellValue("會員姓名");
			row6.createCell(2).setCellValue(oebe.get(0).getMemberName());
			row6.createCell(5).setCellValue("訂單日期");
			row6.createCell(6).setCellValue(oebe.get(0).getOorderDate().substring(0,11));
			
			//樣式設定
			//style1
			CellStyle style1=excelbook.createCellStyle();
			style1.setBorderBottom(BorderStyle.THIN);
			style1.setBorderTop(BorderStyle.THIN);
			style1.setBorderLeft(BorderStyle.THIN);
			style1.setBorderRight(BorderStyle.THIN);
			style1.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
			style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			//style2
			CellStyle style2=excelbook.createCellStyle();
			style2.setBorderBottom(BorderStyle.THIN);
			style2.setBorderTop(BorderStyle.THIN);
			style2.setBorderLeft(BorderStyle.THIN);
			style2.setBorderRight(BorderStyle.THIN);
			
			
			HSSFRow row7=sheet.createRow(7);
			
			Cell[] cell7=new Cell[6];
			for (int i=0;i<6;i++) {
				cell7[i]=row7.createCell(i+1);
				cell7[i].setCellStyle(style1);
			}
			cell7[0].setCellValue("項次");
			cell7[1].setCellValue("商品名稱");
			cell7[2].setCellValue("單價");
			cell7[3].setCellValue("數量");
			cell7[4].setCellValue("小計");
			cell7[5].setCellValue("備註");			
			
			HSSFRow row;
			int num=1;
			int count=8;
			for(OorderExcelByEmployee o:oebe) {
				row=sheet.createRow(count);
				Cell[] cell=new Cell[6];
				if(count%2==0) {
					for (int i=0;i<6;i++) {
						cell[i]=row.createCell(i+1);
						cell[i].setCellStyle(style2);
					}
				} else {
					for (int i=0;i<6;i++) {
						cell[i]=row.createCell(i+1);
						cell[i].setCellStyle(style1);
					}
				}

				cell[0].setCellValue(num);
				cell[1].setCellValue(o.getProductName());
				cell[2].setCellValue(o.getPrice());
				cell[3].setCellValue(o.getQuantity());
				cell[4].setCellValue(o.getSubTotal());
				cell[5].setCellValue("");
				num++;
				count++;
			}
			
			row=sheet.createRow(count);
			row.createCell(5).setCellValue("合 計");
			row.createCell(6).setCellValue(oebe.get(0).getTotalAmount());
			count++;
			
			row=sheet.createRow(count);
			row.createCell(5).setCellValue("折 扣");
			row.createCell(6).setCellValue(oebe.get(0).getDiscount());
			count++;
			
			row=sheet.createRow(count);
			row.createCell(5).setCellValue("折扣後金額");
			row.createCell(6).setCellValue(oebe.get(0).getFinalAmount());
			count++;
			
			row=sheet.createRow(count);
			row.createCell(5).setCellValue("付款方式");
			row.createCell(6).setCellValue(oebe.get(0).getPaymentMethod());
			count++;
			
			for(int i=0;i<10;i++) {
				sheet.setDefaultColumnWidth(10);		
			}
			
			excelbook.write(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
