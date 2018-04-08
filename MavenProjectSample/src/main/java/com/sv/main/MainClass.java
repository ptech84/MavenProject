package com.sv.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sv.testutil.TestUtil;

public class MainClass {
	public static Properties prop;
	public static WebDriver driver;
	
	public MainClass(){
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:/Users/e3009192/workspace2/MavenProjectSample/src/main/java/com/sv/config/properties/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
			public static void Initialization(){
				String browserName = prop.getProperty("browser");
				if(browserName.equals("ie")){
				
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					capabilities.setCapability("requireWindowFocus", true);
				System.setProperty("webdriver.ie.driver", "C:/Selenium/BrowserDrivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
				
				}
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait_Timeout, TimeUnit.SECONDS);
				driver.get(prop.getProperty("url"));
						
				
			}



}
