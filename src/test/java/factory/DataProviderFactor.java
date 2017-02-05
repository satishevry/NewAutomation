package factory;

import dataprovider.ConfigDataProvider;
import dataprovider.ExcelDataProvider;

/*For directly returing the object we have created a class in Data Provider*/
public class DataProviderFactor
{

	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
	}
	
public static ExcelDataProvider getExcel()
		{
			ExcelDataProvider excel=new ExcelDataProvider();
			return excel;
		}
		
	
}