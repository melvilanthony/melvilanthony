package com.atf.com.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atf.com.base.TestBase;
import com.atf.com.util.TestUtil;


public class LoginPage extends TestBase{

	TestUtil testutils;
	Properties prop;
	
	//Searching the Elements
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initialization of the Page object
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Acion
	public boolean crmLoginImg() {
		return crmLogo.isDisplayed();
	}
	public HomePage loginBtn(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	public String  verifyCrmTitle() {
		return driver.getTitle();
	}
		
}
