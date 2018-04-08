package com.sv.testutil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sv.main.MainClass;

public class TestUtil extends MainClass{


	public static long Page_Load_Timeout = 20;
	public static long Implicit_Wait_Timeout = 20;
	
		
	
		public static ArrayList<Object[]> getDataFromExcel(){
			Xls_Reader reader;	
			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
			
			reader = new Xls_Reader(System.getProperty("user.dir")+"/src/main/java/com/sv/tests/SVTestData.xlsx");
			for(int i=2;i<reader.getRowCount("Sheet1");i++){
				
				String acctNo = reader.getCellData("Sheet1", 0, i);
				Object ob[] = {acctNo};
				myData.add(ob);
				
				
				
			}
			return myData;
			
		}
				
			public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

