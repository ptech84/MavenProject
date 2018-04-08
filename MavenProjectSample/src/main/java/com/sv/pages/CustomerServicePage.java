package com.sv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.main.MainClass;
import com.sv.testutil.TestUtil;
import com.sv.testutil.Xls_Reader;

public class CustomerServicePage extends MainClass {
	
		
	@FindBy(xpath=".//*[@id='TXTACCTNBR']")
	WebElement AcctNumber;
	
	@FindBy(xpath=".//*[@id='CMDLOCATE']")
	WebElement LocateBtn;
	
	public CustomerServicePage(){
		PageFactory.initElements(driver, this);
	}


}
