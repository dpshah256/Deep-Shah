package com.launchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunching {

	public static void main(String[] args) {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "F:\\deep\\software\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.amazon.in");
		
		 driver = new FirefoxDriver();
		 System.setProperty("webdriver.gecko.driver", "F:\\deep\\software\\geckodriver.exe");
		 driver.get("https://www.bestbuy.com");

	}

}
