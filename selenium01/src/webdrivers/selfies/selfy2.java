package webdrivers.selfies;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class selfy2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\deep\\software\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com ");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.linkText("Rajni-kanth"));
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("C:\\Users\\Jay Shah\\Desktop\\selfy1.PNG"));
		
		/*
		 * String links = driver.findElement(By.linkText("Customer service")).getText();
		 * System.out.println(links);
		 */
		
		//  List<WebElement> links1 = driver.findElements(By.tagName("a")); 
		  /*
		  for (int i =
		 * 0; i < links.size(); i++) { System.out.println(links.get(i).getText()); }
		 */
		/*
		 * for(WebElement l : links1) { System.out.println(l); }
		 */
		/*
		 * List<WebElement> links1 =
		 * driver.findElements(By.xpath("//div[@id='nav-xshop']/a")); for(WebElement 1 :
		 * links1) { System.out.println(l.getText()); }
		 */
		
	}

}
