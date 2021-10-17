package com.launchings;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class TC_003 extends BaseTest {
	
	private static final Logger log = Logger.getLogger(TC_003.class);

	public static void main(String[] args) throws Exception {
		init();
		log.info("loadind the properties file");
		launch("chromebrowser");
		log.info("launchind the browser");
		navigate("amazonurl");
		log.info("navigate the url");
		selectOption("amazonsearchdrop_id","Books");
		log.info("navigate the url");
		typeText("twotabsearchtextbox","Harry-potter");
		log.info("selecting the books");
		clickElement("amazonsearchbutton_xpath");
		log.info("clickinf the element");
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


