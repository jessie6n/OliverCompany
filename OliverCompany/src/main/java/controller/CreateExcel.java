/*
 * 1.FileOutputStream(寫入檔案) , FileInputStream(讀取檔案)
 * 
 * 
 * 2.HSSFWorkbook excelBook=new HSSFWorkbook(fis);-->產生excel物件
 * 3.HSSFSheet sheet=excelBook.getSheet(sheetName);-->產生工作表
 * 
 * ->int count=sheet.getPhysicalNumberOfRows();-->讀取目前工作表有內容的列數
 * 
 * 4.HSSFRow row=sheet.createRow(count);-->寫入第幾列
 * 5.row.createCell(0).setCellValue(name);-->同一列的儲存格位置
 * 
 * 
 * 
 * 
 * 
 * 
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Employee;

public class CreateExcel {

	public static void main(String[] args) {
		
		//CreateExcel.createExcelFile("test","員工資料表");
		//CreateExcel.insertValue("test","員工資料表",);
	
	}
	
	//新增檔案+資料表
	public static void createExcelFile(String filename, String sheetname) {
		try {
			FileOutputStream file=new FileOutputStream(filename+".xls");
			HSSFWorkbook excelbook=new HSSFWorkbook();
			HSSFSheet sheet=excelbook.createSheet(sheetname);
			
			HSSFRow row=sheet.createRow(0);
			row.createCell(0).setCellValue("員工編號");
			row.createCell(1).setCellValue("員工姓名");
			row.createCell(2).setCellValue("員工電話");
			row.createCell(3).setCellValue("員工地址");
			
			excelbook.write(file);
			file.flush();
			file.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//填入資料-->讀取舊檔-->讀取工作表
	public static void insertValue(String filename, String sheetname, Employee employee) {
		try {
			FileInputStream fis=new FileInputStream(filename+".xls");//開啟舊檔
			HSSFWorkbook excelbook=new HSSFWorkbook(fis);
			HSSFSheet sheet=excelbook.getSheet(sheetname);//指定工作表
			int count=sheet.getPhysicalNumberOfRows();//查目前第幾筆有資料
			
			HSSFRow row=sheet.createRow(count);
			row.createCell(0).setCellValue(employee.getEmployeeid());
			row.createCell(1).setCellValue(employee.getName());
			row.createCell(2).setCellValue(employee.getPhone());
			row.createCell(3).setCellValue(employee.getAddress());
			
			FileOutputStream fos=new FileOutputStream("test.xls");
			excelbook.write(fos);//寫入資料
			fos.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}