package com.atf.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atf.com.base.TestBase;
import com.atf.com.pages.ContactPage;
import com.atf.com.pages.HomePage;
import com.atf.com.pages.LoginPage;
import com.atf.com.util.TestUtil;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactPage;
	TestUtil testutils;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();	
		testutils = new TestUtil();
		homePage = new HomePage();
		loginPage.loginBtn(prop.getProperty("username"),prop.getProperty("password"));
		testutils.switchToFrame();
	}
	@Test(priority = 1)
	public void homePageloginUserNameTest() {
		
	String text = homePage.homePageloginUserName();	
	System.out.println(text);
	Assert.assertEquals(text, "  User: Demo User");
	}	
	@Test(priority = 2)
	public void verifyContactlinkTest() {
		
	contactPage = homePage.verifyContactlink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
