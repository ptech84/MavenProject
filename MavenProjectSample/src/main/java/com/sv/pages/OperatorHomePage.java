package com.sv.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.main.MainClass;

public class OperatorHomePage extends MainClass{
	
	@FindBy(xpath=".//*[@id='CMDSIGNON']")
	WebElement OperatorSignOnBtn;
	
	@FindBy(xpath=".//*[@id='CMDSIGNOFF']")
	WebElement OperatorSignOffBtn;
	
	@FindBy(xpath=".//*[@id='CMDEXIT']")
	WebElement ExitBtn;
	
	public OperatorHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
		
	public OperatorSignOnPage ClickOnOperatorSignOnBtn() throws InterruptedException{
		Thread.sleep(5000);
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		OperatorSignOnBtn.click();
		return new OperatorSignOnPage();
	}

}
