package stepDefinitions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resources\\features", 
        glue= {"stepDefinitions"},
       	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
        tags="@smoke"
)
public class TestRunner {
	
}
