package com.sv.testng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sv.main.MainClass;
import com.sv.pages.CustomerServicePage;
import com.sv.pages.OperatorHomePage;
import com.sv.pages.OperatorSignOnPage;
import com.sv.pages.SVAllWindows;
import com.sv.pages.ServiceViewHomePage;
import com.sv.testutil.TestUtil;


public class LoginTest extends MainClass{
	OperatorHomePage OpHomePage;
	ServiceViewHomePage svHomePage;
	OperatorSignOnPage OpSignOnPage;
	SVAllWindows SVAllWindows;
	CustomerServicePage CustomerServicePage;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
	
	public LoginTest(){
		super();
	}
	
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Praveen");
		extent.addSystemInfo("User Name", "Praveen Automation");
		extent.addSystemInfo("Environment", "QA");
		
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException, IOException{
		Initialization();
		svHomePage = new ServiceViewHomePage();
		OpHomePage = new OperatorHomePage();
		OpSignOnPage = new OperatorSignOnPage();
		SVAllWindows = new SVAllWindows();
		CustomerServicePage = new CustomerServicePage();
		
		//login to SV application
		svHomePage.ClickOnClickHereToBeginLink();
		OpHomePage.ClickOnOperatorSignOnBtn();
		OpSignOnPage.LoginToSV();
		
	}

	@Test(priority=1, enabled=true,invocationCount=2,groups="sample1")
	public void TestCase1() throws InterruptedException{
		extentTest = extent.startTest("TestCase1");
		Thread.sleep(5000);
		SVAllWindows.ClickOnCustomerServiceTab();
	}
	
	@Test(enabled=false)
	public void TestCase2(){
		extentTest = extent.startTest("TestCase2");
		//click on CustomerService Tab
		SVAllWindows.ClickOnCustomerServiceTab();
		// locating the account
		driver.findElement(By.xpath(".//*[@id='TXTACCTNBR']")).sendKeys("5271787164181847");
		driver.findElement(By.xpath(".//*[@id='CMDLOCATE']")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	/*@DataProvider
	public Iterator<Object[]> getDataExcel(){
		
		ArrayList<Object[]> testData =  TestUtil.getDataFromExcel();
		return testData.iterator();
		
			
			
		}*/
	
	@AfterMethod
			public void tearDown(ITestResult result) throws IOException{
		//teardown
			
			if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
				
				String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
					}
			
			
			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			driver.quit();
			
			
			
		}


	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	

}
