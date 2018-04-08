package com.sv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.main.MainClass;

public class ServiceViewHomePage extends MainClass{
	
	
	@FindBy(xpath="//font[contains(text(),'Region SIT Upgrade')]")
	WebElement HomePageTitle;
	
	@FindBy(xpath="//a[contains(text(),'Click')]")
		WebElement ClickHereToBegin;

	
	public ServiceViewHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public OperatorHomePage ClickOnClickHereToBeginLink(){
		ClickHereToBegin.click();
		return new OperatorHomePage();
	}

}
