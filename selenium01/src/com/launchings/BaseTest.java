package com.launchings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
public static WebDriver driver;
public static String projectpath = System.getProperty("user.dir");
public static Properties p;
public static FileInputStream fis;
public static Properties mainProp;
public static Properties childprop;
public static Properties orprop;
public static ExtentReports report;
public static ExtentTest test;

public static void init() throws Exception {
	 fis = new FileInputStream(projectpath+"//data.properties");
    p = new Properties();
	p.load(fis);
	
	fis = new FileInputStream(projectpath+"//environment.properties");
	mainProp = new Properties();
	mainProp.load(fis);
	 String e = mainProp.getProperty("env");
	 System.out.println(e);
	 
	 fis = new FileInputStream(projectpath+"//"+e+".properties");
	 childprop = new Properties();
	 childprop.load(fis);
	 String value = childprop.getProperty("amazonurl");
	 System.out.println(value);
	 
	 fis = new FileInputStream(projectpath+"//or.properties");
	 orprop = new Properties();
	 orprop.load(fis);
	 
	 
	 fis = new FileInputStream(projectpath+"//log4jconfig.properties");
	 PropertyConfigurator.configure(fis);
	 
	 report = Extentmanager.getInstance();
}
public static void launch(String browser) {
	if (p.getProperty(browser).equals("chrome")) {
		//System.setProperty("webdriver.chrome.driver", "F:\\deep\\software\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", projectpath+"//drivers//chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("user-data-dir=C:\\Users\\Jay Shah\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		option.addArguments("--disable-notifications");
		 driver = new ChromeDriver(option);
	}
	else if (p.getProperty(browser).equals("firefox")) {
	//	System.setProperty("webdriver.gecko.driver", "F:\\deep\\software\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectpath+"//drivers//geckodriver.exe");
		ProfilesIni p = new ProfilesIni();
		FirefoxProfile profile = p.getProfile("deepprofile");
		profile.setPreference("dom.webnotifications.enabled", false);
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		 driver = new FirefoxDriver(option);
		 
	}
	driver.manage().window().maximize();
}
public static void navigate(String url) {
	driver.get(childprop.getProperty(url));
}

public static void windowRefresh() {
	driver.navigate().refresh();
	
}

public static void windowForward() {
	driver.navigate().forward();
	
}

public static void windowback() {
	driver.navigate().back();
	
}

public static String windowCurrentUrl() {
	return driver.getCurrentUrl();
	
}

public static void deleteCookies() {
	driver.manage().deleteAllCookies();
	
}

public static String windowTitle() {
	
	return driver.getTitle();
}

public static void windowMaximize() {
	driver.manage().window().maximize();
	
}

public static void waitForElement(int timeMilesesonds) throws Exception {
	Thread.sleep(timeMilesesonds);
	
}


public static void windowClose() {
	driver.quit();
	
}
public static void clickElement(String locatorKey) {
	getElement(locatorKey);
	
	//driver.findElement(By.xpath(orprop.getProperty(locatorKey))).click();
}

public static void typeText(String locatorKey, String text) {
	getElement(locatorKey);
	//driver.findElement(By.name(orprop.getProperty(locatorKey))).sendKeys(text);
}

public static void selectOption(String locatorKey, String option) {
	getElement(locatorKey);
//	driver.findElement(By.id(orprop.getProperty(locatorKey))).sendKeys(option);
}
public static WebElement getElement(String locatorKey) {
	WebElement element = null;
	
	if (locatorKey.endsWith("_id")) {
		element = driver.findElement(By.id(orprop.getProperty(locatorKey)));
	}else if (locatorKey.endsWith("_name")) {
	element	= driver.findElement(By.name(orprop.getProperty(locatorKey)));
	}else if (locatorKey.endsWith("_className")) {
	element	= driver.findElement(By.className(orprop.getProperty(locatorKey)));
	}else if (locatorKey.endsWith("_xpath")) {
		element = driver.findElement(By.xpath(orprop.getProperty(locatorKey)));
	}else if (locatorKey.endsWith("_css")) {
		element = driver.findElement(By.cssSelector(orprop.getProperty(locatorKey)));
	}else if (locatorKey.endsWith("_linktext")) {
		element = driver.findElement(By.linkText(orprop.getProperty(locatorKey)));
	}else if (locatorKey.endsWith("_partiallinktext")) {
		element = driver.findElement(By.partialLinkText(orprop.getProperty(locatorKey)));
	}
	return element;
}

/***********************verifications***************************/
public static boolean verifyLinkEqual(String expectedLink) {
	String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHtml");
	if(actualLink.equals(expectedLink))
	return true;
	else 
		return false;
	}
//**************************reporting****************************
public static void reportSuccess(String successMsg) {
	test.log(LogStatus.PASS,successMsg );
	
}

public static void reprotFailure(String FailureMsg) {
	test.log(LogStatus.FAIL, FailureMsg);
	
}
}

