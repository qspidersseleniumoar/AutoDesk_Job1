package com.autodesk.crm.dataproviders.leads;

import org.testng.annotations.DataProvider;

import com.autodesk.crm.commonlib.IFilePaths;

import static com.autodesk.crm.commonlib.ExcelLib.*;

/**
 * 
 * @author Ramya
 *
 */
public class LeadsData implements IFilePaths{
	
	private static Object[][] obj;
	
	@DataProvider
	public Object[][] create20Leads() throws Throwable {
		obj = new Object[20][3];
		openSheet(LDS, "Create");
		for(int i=1;i<=20;i++) {
			for(int j=0;j<3;j++) {
			obj[i-1][j] = getData(i-1, j);
			}
		}
		closeBook();
		return obj;
	}
}
