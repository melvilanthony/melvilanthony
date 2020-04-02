package com.atf.com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atf.com.base.TestBase;
import com.atf.com.pages.ContactPage;
import com.atf.com.pages.HomePage;
import com.atf.com.pages.LoginPage;
import com.atf.com.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	ContactPage contactPage;
	LoginPage  loginPage;
	HomePage   homePage;
	TestUtil testutil;
	String sheetName = "contacts";	
	
	public ContactPageTest() {
	
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactPage = new ContactPage();
		testutil = new TestUtil();
		homePage = loginPage.loginBtn(prop.getProperty("username"),prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		testutil.switchToFrame();
		contactPage = homePage.MoveToContactPage();
	//	contactPage = homePage.verifyContactlink();
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);		
		return data;
	}

	@Test(priority=3, dataProvider="getCRMTestData")
		public void validateCreateNewContact(String title, String firstName, String lastName, String company){
			contactPage.CliclonNewContactlink();
			//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
			contactPage.createNewContact(title, firstName, lastName, company);
			
		}
   @Test(priority = 1)
	public void verifyCreateNewContact() {
		contactPage.CliclonNewContactlink();
	}
   
	@Test(priority=2)
	public void selectMultipleContactsTest(){
		contactPage.selectContactsByName("ara pie");
		contactPage.selectContactsByName("Betty Jones");
	}
	
	/*@Test(priority = 1)
	public void createNewContactTest() {
			
	//	contactPage.createNewContact("Mr.", "Melvil", "Rebello", "Datamatics");
	}*/
	
	@AfterMethod
	public void setup() {
		driver.quit();
	}
	
	
}
