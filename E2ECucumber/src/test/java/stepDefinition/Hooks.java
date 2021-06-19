package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before("@Homepage")
	public void beforeTest() {
		System.out.println("HomePage test starts");
	}
	
	@Before("@ValidationTitle")
	public void beforeValidTitle()
	{
		System.out.println("ValidTitle test starts");
	}
	
	@Before("@ValidationNavbar")
	public void beforeValidNav()
	{
		System.out.println("ValidationNavbar test starts");
	}
	
	@After("@Homepage")
	public void AfterTest() {
		System.out.println("HomePage test Ends");
	}
	
	@After("@ValidationTitle")
	public void AfterValidTitle()
	{
		System.out.println("ValidTitle test Ends");
	}
	
	@After("@ValidationNavbar")
	public void AfterValidNav()
	{
		System.out.println("ValidationNavbar test Ends");
	}
}
