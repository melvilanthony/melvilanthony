package com.atf.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atf.com.base.TestBase;

public class HomePage extends TestBase{
	
	//Finding webelement
	@FindBy(xpath = "//td[contains(text(),'Demo User')]")
	WebElement loginUserName;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactlink;	
	
			
	//Initialization of Page Objects
   public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String homePageloginUserName() {
	
		return loginUserName.getText();
		
	}
	
	public ContactPage verifyContactlink() {
		contactlink.click();
		//driver.manage().timeouts().implicitlyWait(testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		return new ContactPage();
	}
	public ContactPage MoveToContactPage() {
		
		return new ContactPage();
	}
	
	
	
	
}
