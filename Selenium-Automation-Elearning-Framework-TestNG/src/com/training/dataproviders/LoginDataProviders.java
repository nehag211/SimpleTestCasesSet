package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ELTC_068Bean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ELTC_068Bean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ELTC_068Bean temp : list){
			Object[]  obj = new Object[list.size()]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.geteMail(); 
			obj[3] = temp.getPhone(); 
			obj[4] = temp.getLogin(); 
			obj[5] = temp.getPassword(); 
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Neha/Desktop/RTTD_064.xlsx";
		String validDatasheetName="ELTC_0067";
		String InValidDatasheetName="ELTC_0069";
		return new ApachePOIExcelRead().getExcelContent(fileName,validDatasheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		String fileName ="C:/Users/Neha/TestSet/SimpleTestcase/Selenium-Automation-Elearning-Framework-TestNG/resources/RTTD_064.xlsx";
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData(fileName, "ELTC_067"); 
	}
}
