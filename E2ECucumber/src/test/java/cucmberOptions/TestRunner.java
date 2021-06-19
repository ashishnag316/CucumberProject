package cucmberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
tags= {"@Homepage, @ValidationTitle, @ValidationNavbar"}, 
glue = {"stepDefinition"}, plugin = {"pretty","html:target/cucmber", "json:target/cucumber.json", "junit:target/cukes.xml"})

public class TestRunner extends AbstractTestNGCucumberTests {

}

//can be written as tags= {"@Homepage or @ValidationTitle or @ValidationNavbar"}
//to run all tests except HomePage using tags = {"not @Homepage"}
////tags= {"@Homepage and @ValidationTitle"} => scenarios with both these tags run