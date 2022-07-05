package stepDefinitions;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageFactor.LoginPage;
import utility.BaseClass;
import utility.Constrants;

public class Login extends BaseClass{

	LoginPage loginPage ;
	String userName ;
	String password ;

	@Given("tekExperience app to login")
	public void tek_experience_app_to_login() throws Exception 
	{
		JSONObject jsonEntireObject =(JSONObject) readJsonData(Constrants.urlsPath);

		String browser = (String) jsonEntireObject.get("Browser");
		System.out.println("Application opening on the drowser : "+browser);

		String url = ((JSONObject) jsonEntireObject.get("URLS")).get("QA").toString();
		System.out.println("Application URL : "+url);	

		driver = launchBrowser(browser,url);

		loginPage = PageFactory.initElements(driver, LoginPage.class);

	}

	@Then("enter username")
	public void enter_username() throws Exception
	{
		JSONObject jsonEntireObject =(JSONObject) readJsonData(Constrants.userCredentialsPath);

		userName = ((JSONObject) jsonEntireObject.get("user1")).get("userId").toString();
		password = ((JSONObject) jsonEntireObject.get("user1")).get("password").toString();

		Thread.sleep(2000);

		loginPage.enterUserName(userName);

	}

	@And("click on login button")
	public void click_on_login_button() throws Exception 
	{
		loginPage.clickLoginBtn();
		Thread.sleep(3000);
		switchWindowOrTab(1);
		loginPage.enter_Email(userName,password);
		switchWindowOrTab(0);
	}

	@Then("Verify the user login")
	public void verify_the_user_login() throws Exception
	{
        Assert.assertTrue(loginPage.verifyUserLogin());	
	}



}
