package dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	/*Global variable*/	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		/*Loading the File with Folder name and file name*/
		File src = new File ("./TestData/AppData.xlsx");
		
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			
			 wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) 
		{
		
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	
	public String getData(int sheetIndex,int row, int column)
	{
		String data= wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getData(String sheetName,int row, int column)
	{
		String data= wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
}
