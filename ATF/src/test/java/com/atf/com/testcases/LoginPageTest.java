package com.atf.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atf.com.base.TestBase;
import com.atf.com.pages.HomePage;
import com.atf.com.pages.LoginPage;
import com.atf.com.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	TestUtil testutils;
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
//		String currentDir = System.getProperty("user.dir");
//		System.out.println(currentDir);
//		Output
//		C:\Users\Jacob's PC\Favorites\eclipse-workspace\Selenium Project\ATF
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void crmLoginImgtest() {
		boolean flag = loginPage.crmLoginImg();
		Assert.assertEquals(flag, true , "No image");
	}
	
	@Test(priority = 2)
	public void verifycrmTitleTest() {
	String title = loginPage.verifyCrmTitle();	
	System.out.println(title);
	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}	
	
	@Test(priority = 3)
	public void verifyLoginBtntest() {
	 homePage =	loginPage.loginBtn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	}
