package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;


 public class Utility extends Base {

	public static void initializerDriver(String string) {
  
		try {
			file = new FileInputStream(".\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(file);

			if (prop.getProperty("browser").equals("chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else {
				driver = new OperaDriver();
				driver.manage().window().maximize();

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public Object[][] getLoginData() {
		try {
			excelFile = new FileInputStream(FILE_PATH);
			XSSFWorkbook xWorkbook = new XSSFWorkbook(excelFile); 			
			XSSFSheet xSheet = xWorkbook.getSheet("LoginData");
			int lastRow = xSheet.getLastRowNum();
			   
			data = new Object[lastRow][lastRow];
			int k=0;
			for (int i = 1; i < lastRow; i++) {
				String username = xSheet.getRow(i).getCell(k).getStringCellValue();
				String password = xSheet.getRow(i).getCell(k).getStringCellValue();
				System.out.println("Row" + i + " username: " +username);
				System.out.println("Row" + i + " password: " +password);
				System.out.println();
				data[i][0]= username;
				data[i][1]=password;

			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return data;
	
	}
	
	public static List<List<String>>excelReader() throws IOException{
		List<List<String>> values = new LinkedList<List<String>>();
		File file = new File(FILE_PATH);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("LoginData");
		
		int rowCount = sheet.getLastRowNum();
		
		for (int i=1; i<=rowCount; i++) {
			int cellCount = sheet.getRow(i).getLastCellNum();
			List<String>val = new LinkedList<String>();
		
			for (int j=0; j < cellCount; j++ )	{
				val.add(sheet.getRow(i).getCell(j).getStringCellValue());
				
		}
			values.add(val);
			
		}
		return values;
			
	}
	


	public static void closeDriver() {
		try {
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
