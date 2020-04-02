package com.atf.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.atf.com.base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactlink;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContact;

	

	
	public void createNewContact(String title, String ftName, String ltName, String comp){
		
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	public void CliclonNewContactlink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactlink).build().perform();
		newContact.click();		
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
}
