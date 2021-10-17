package verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\deep\\software\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		//String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHtml");
String expectedLink = "Cust Serv";

System.out.println("Actual Link :"+actualLink);
System.out.println("Expected Link :"+expectedLink);

//if(actualLink.equals(expectedLink))  
//if(actualLink.equalsIgnoreCase(expectedLink))
if(actualLink.contains(expectedLink)) //case sensitive
	System.out.println("both links are equal");
else
	System.out.println("both links are not equal");
	}

}
