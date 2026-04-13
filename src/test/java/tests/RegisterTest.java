package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{
	
	//Empty Fields Validation Test
	@Test
	public void emptyFieldsValidationTest() {
	    HomePage hp = new HomePage(getDriver());
	    RegisterPage rp = hp.clickRegister();
	    rp.registerBtnClick("", "");

	    Assert.assertTrue(getDriver().findElement(rp.name).getAttribute("validationMessage").length() > 0,"Validation message not shown for empty name/email");
	}
	
	//Invalid Email Validation Test
	@Test
	public void invalidEmailTest() {
	    HomePage hp = new HomePage(getDriver());
	    RegisterPage rp = hp.clickRegister();
	    rp.registerBtnClick("Vaishnavi", "invalidemail");

	    String validationMsg = getDriver().findElement(rp.email).getAttribute("validationMessage");

	    Assert.assertTrue(validationMsg.contains("@"),"Invalid email validation not triggered");
	}
}
