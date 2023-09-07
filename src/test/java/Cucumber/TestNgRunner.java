package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Cucumber",glue="CumberStepDefinations",
monochrome = true,tags="@Errorvalidation",plugin = {"html:cumberTest/cucumber.html"})
public class TestNgRunner extends AbstractTestNGCucumberTests {


}
