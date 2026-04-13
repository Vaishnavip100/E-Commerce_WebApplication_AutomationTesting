package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelUtil;

public class LoginTest extends BaseTest{
	
	ConfigReader config = new ConfigReader();

	@DataProvider(name="LoginData")
	public Object[][] getTest(){
	    return ExcelUtil.getTestData(config.getTestDataPath(), "Sheet1");
	}
	
	@Test(dataProvider = "LoginData")
	public void login(String email, String password, String expected) {
		HomePage hp=new HomePage(getDriver());
		LoginPage lp=hp.clickLogin();
		lp.login(email, password);
		
		if (expected.equalsIgnoreCase("success")) {
	        Assert.assertTrue(lp.isLoginSuccessful(), "Login should succeed but failed: "+ email);
	    } 
	    else if (expected.equalsIgnoreCase("failure")) {
	        Assert.assertTrue(lp.isLoginFailed(), "Login should fail but passed: "+email);
	    }
	    else {
	        Assert.fail("Invalid expected value in test data");
	    }
	}
	
	@Test
	public void verifyLogout() {
		HomePage hp=new HomePage(getDriver());
		LoginPage lp=hp.clickLogin();
		
		lp.login(config.getEmail(), config.getPassword());
		lp.clickLogoutBtn();
		
		// Verify not redirected to home page
		Assert.assertFalse(getDriver().getCurrentUrl().equals("https://automationexercise.com/"),"User should not be redirected to home page");
		
		// Verify redirected to login page
	    Assert.assertTrue(getDriver().getCurrentUrl().contains("login"),"User not redirected to login page after logout");
	}
}
