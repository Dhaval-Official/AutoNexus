package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() {
		
		String path = "./testData/LoginData.xlsx";
		
		//created object of Excel Reader
		ExcelReader xlutil = new ExcelReader(path);
		
		int rows = xlutil.getRowCount("Sheet1");			//total rows
		int cols = xlutil.getColumnCount("Sheet1");		//total Cols
		
//		System.out.println(totalRows);
		
		String data[][] = new String[rows-1][cols];
		
		for(int row=2; row<=rows; row++) {
			for(int col=0; col<=cols; col++) {
				data[row-2][col] = xlutil.getCellData("Sheet1", col, row);
			}
		}
		
		return data;
				
	}
	
	@DataProvider(name="LoginData")
	public String[][] getDataforRegistration() {
		
		String path = "./testData/OtherData.xlsx";			//this file does no EXIST
		
		//created object of Excel Reader
		ExcelReader xlutil = new ExcelReader(path);
		
		int rows = xlutil.getRowCount("Sheet1");			//total rows
		int cols = xlutil.getColumnCount("Sheet1");		//total Cols
		
//		System.out.println(totalRows);
		
		String data2[][] = new String[rows-1][cols];
		
		for(int row=2; row<=rows; row++) {
			for(int col=0; col<=cols; col++) {
				data2[row-2][col] = xlutil.getCellData("Sheet1", col, row);
			}
		}
		
		return data2;
				
	}
	

}
