package com.sv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.main.MainClass;

public class SVAllWindows extends MainClass{
	
	@FindBy(xpath=".//*[@id='CMDCUSTSRV']")
	WebElement CustomerServiceTab;
	
	@FindBy(xpath=".//*[@id='CMDMONETARYENTRY']")
	WebElement MonetaryEntryTab;
	
	public SVAllWindows(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void ClickOnCustomerServiceTab(){
		CustomerServiceTab.click();
	}
	
	
	
}
