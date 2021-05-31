package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.ForgotPWDPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class DefiningSteps extends Base{
	public WebDriver driver;
	public LandingPage lp;
	public LoginPage lgn ;
	public ForgotPWDPage fp;
	String actual;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
    @Given("^initialize the browser$")
    public void initialize_the_browser() throws Throwable {
    	driver =initializeDriver();
    	
    }
    
    @Given("^Navigate to landing page of \"([^\"]*)\"$")
    public void navigate_to_landing_page_of_something(String strArg1) throws Throwable {
        
    	driver.get(strArg1);
		log.info("Navigated to home page");
    }

    
    @Given("^click on login button$")
    public void click_on_login_button() throws Throwable {
    	lp = new LandingPage(driver);
		lgn = lp.loginBtn();
		if(lp.getPopupSize()>0)
		{
			lp.getPopup().click();
		}
		log.info("Login Button is clicked");
    }

   /* @When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_something_and_something_and_something(String strArg1, String strArg2, String strArg3) throws Throwable {
    	
    	lgn.emailID().sendKeys(strArg1);
		log.info("EmailId is entered");
		lgn.password().sendKeys(strArg2);
		log.info("Pwd is entered");
		System.out.println(strArg3);
		log.info("Type of user is printed");
		
    }*/
    
    @When("^user enters (.+) and (.+) and (.+)$")
    public void user_enters_and_and(String username, String password, String usertype) throws Throwable {
    	lgn.emailID().sendKeys(username);
		log.info("EmailId is entered");
		lgn.password().sendKeys(password);
		log.info("Pwd is entered");
		System.out.println(usertype);
		log.info("Type of user is printed");
    }

    @Then("^click on login button of loginpage and user is logged in successfull$")
    public void click_on_login_button_of_loginpage_and_user_is_logged_in_successfull() throws Throwable {
    	lgn.login().click();
		log.info("login btn clicked");	
    }
    	

   /* @And("^click on forgotpassword and enter \"([^\"]*)\"$")
    public void click_on_forgotpassword_and_enter_something(String strArg1) throws Throwable {
    	fp = lgn.fgtPWD();
		fp.emailID().sendKeys(strArg1);
    }*/
    
    @And("^click on forgotpassword and enter (.+)$")
    public void click_on_forgotpassword_and_enter(String emailid) throws Throwable {
    	fp = lgn.fgtPWD();
		fp.emailID().sendKeys(emailid);
    }

    @And("^click on reset password$")
    public void click_on_reset_password() throws Throwable {
    	fp.resetLink().click();
    }
    
   
    @When("^get the title$")
    public void get_the_title() throws Throwable {
    	lp = new LandingPage(driver);
		actual = lp.title().getText();
    }
    
    @When("^find the navigation bar$")
    public void find_the_navigation_bar() throws Throwable {
    	lp = new LandingPage(driver);
    }

    @Then("^compare expected string \"([^\"]*)\" with actual and show the result$")
    public void compare_expected_string_something_with_actual_and_show_the_result(String strArg1) throws Throwable {
    	
		Assert.assertEquals(actual, strArg1);
    }
    
    

    @Then("^Verify navigation bar is displayed$")
    public void verify_navigation_bar_is_displayed() throws Throwable {
    	
		Assert.assertTrue(lp.navBar().isDisplayed());
    }
    
    @And("^close browser$")
    public void close_browser() throws Throwable {
       driver.close();
    }
    

}