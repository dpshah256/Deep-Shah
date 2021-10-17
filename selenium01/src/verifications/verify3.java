package verifications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.launchings.BaseTest;
import com.relevantcodes.extentreports.LogStatus;



public class verify3 extends BaseTest {

	public static void main(String[] args) throws Exception {
		init();
		launch("chromebrowser");
		navigate("amazonurl");
		
		test = report.startTest("verify3");
		
		String expectedLink = "Customer Service";
		
		if(!verifyLinkEqual(expectedLink))
			reprotFailure("Both links are not equal");
	//	System.out.println("Both links are not equal");
		else
			reportSuccess("Both links are equal");
		//	System.out.println("Both links are equal");
		
		report.endTest(test);
		report.flush();

	}

	

	

}
