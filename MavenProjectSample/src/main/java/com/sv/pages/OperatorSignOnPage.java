package com.sv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.main.MainClass;

public class OperatorSignOnPage extends MainClass {

	@FindBy(xpath=".//*[@id='TXTOPERATOR']")
	WebElement OperatorTxt;
	
	@FindBy(xpath=".//*[@id='TXTPASSWORD']")
	WebElement PasswordTxt;
	
	@FindBy(xpath=".//*[@id='CMDSIGNON']")
	WebElement SignonBtn;
	
	public OperatorSignOnPage(){
		PageFactory.initElements(driver, this);
	}
	
	public SVAllWindows LoginToSV() throws InterruptedException{
		Thread.sleep(5000);
		OperatorTxt.sendKeys(prop.getProperty("username"));
		PasswordTxt.sendKeys(prop.getProperty("password"));
		SignonBtn.click();
		return new SVAllWindows();
		
		
		
	}
	

}
