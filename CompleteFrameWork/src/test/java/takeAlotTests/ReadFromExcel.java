package takeAlotTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class ReadFromExcel {
	ReadExcel readExcel = new ReadExcel();
	
	@Test(dataProvider="Brand and Quantity")
	public void BrandQuantityInt(String id,String item) {
		System.out.println("ID: " + id + " Item: " + item);
	}
	
	@DataProvider(name = "Brand and Quantity")
	public Object[][] getDataFromExcel(){
		String excelDirectory = readExcel.getDataConfigProperties("excelDataDir");
		Object[][] errObj = readExcel.getExcelData(excelDirectory + "AutomationData.xlsx","sheet1");
		return errObj;
		
	}

}
