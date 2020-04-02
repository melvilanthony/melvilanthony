package com.atf.com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.atf.com.util.TestUtil;
import com.atf.com.util.WebEventListener;

public class TestBase {
	public static FileInputStream file;
	public static Properties prop;
	public static TestUtil testutil;
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
		
	public TestBase() {
		
		try {
			file = new FileInputStream("C:\\Users\\Jacob's PC\\Favorites\\eclipse-workspace\\Selenium Project\\ATF\\src\\main\\java\\com\\atf\\com\\config\\config.Properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	public void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		 driver =  new ChromeDriver();
		}else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecho.driver", "C:\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//To print the steps in the console
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//driver.get(prop.getProperty("url"));
	}
		
		
}
