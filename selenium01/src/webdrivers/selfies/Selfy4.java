package webdrivers.selfies;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Selfy4 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\deep\\software\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			Date d = new Date();
			String dt = d.toString().replace(':', '_').replace(' ', '_');
			
			String linkName = links.get(i).getText();
			links.get(i).click();
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile, new File("C:\\Users\\Jay Shah\\Desktop\\selfy1.PNG"));

	}

}}
