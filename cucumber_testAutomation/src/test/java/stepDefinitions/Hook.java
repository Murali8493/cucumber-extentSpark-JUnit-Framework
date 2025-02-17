package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utility.BaseClass;

public class Hook extends BaseClass {
	
//	public String getScreenshot()
//	{
//		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//	}
	@AfterStep
	public void takesSceenshot(Scenario scenario)
	{
		//if(scenario.isFailed())
		//{
		final byte[] screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");
		//}
	}
	
	@After
	public void quitBrowser() throws Exception
	{
		
		driver.quit();
	}

}
