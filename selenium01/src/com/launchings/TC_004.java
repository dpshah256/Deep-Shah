package com.launchings;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;



public class TC_004 extends BaseTest {
	
	private static final Logger log = Logger.getLogger(TC_003.class);

	public static void main(String[] args) throws Exception {
		init();
		report.startTest("TC_004");
		test.log(LogStatus.INFO, "loadind the properties file");
	
		launch("chromebrowser");
		test.log(LogStatus.PASS, "launchind the browser");
		
		navigate("amazonurl");
		test.log(LogStatus.PASS, "amazonsearchdrop_id","Books");
		
		selectOption("amazonsearchdrop_id","Books");
		test.log(LogStatus.FAIL, "twotabsearchtextbox","Harry-potter");
		
		typeText("twotabsearchtextbox","Harry-potter");
		test.log(LogStatus.PASS, "amazonsearchbutton_xpath");
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.FAIL, "amazonsearchbutton_xpath");
		
		report.endTest(test);
		report.flush();
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Books");
	//	driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry-potter");
	//	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	//	driver.findElement(By.linkText("Customer Service")).click();
		//List<WebElement> links = driver.findElements(By.tagName("a"));
	//	for (int i = 0; i < links.size(); i++) {
		//	if (!links.get(i).getText().isEmpty()) {
			//	System.out.println(links.get(i).getText());
		//	}
		
	//	}

	}

	}


