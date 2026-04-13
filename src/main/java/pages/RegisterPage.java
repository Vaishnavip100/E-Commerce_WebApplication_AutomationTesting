package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class RegisterPage extends BasePage{
	public By name=By.name("name");
	public By email=By.xpath("//input[@data-qa='signup-email']");
	By signupBtn=By.xpath("//button[normalize-space()='Signup']");
	
	By radioBtnMr=By.id("id_gender1");
	By radioBtnMrs=By.id("id_gender2");
	By password=By.id("password");
	By selectDay=By.id("days");
	By selectMonth=By.id("months");
	By selectYears=By.id("years");
	By firstName=By.id("first_name");
	By lastName=By.id("last_name");
	By companyName=By.id("company");
	By address1=By.id("address1");
	By address2=By.id("address2");
	By countrySelect=By.id("country");
	By state=By.id("state");
	By city=By.id("city");
	By zipCode=By.id("zipcode");
	By mobileNo=By.id("mobile_number");
	By createAccount=By.xpath("//button[normalize-space()='Create Account']");
	
	By continueBtn = By.xpath("//a[@data-qa='continue-button']");
	By accountCreatedMsg=By.xpath("//b[normalize-space()='Account Created!']");
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void registerBtnClick(String nameVal, String emailVal) {
        type(name, nameVal);
        type(email, emailVal);
        click(signupBtn);
    }
	
	public void createAccountBtn(String gender, String pass, String day, String month, String year,
            String fname, String lname, String company,
            String addr1, String addr2, String country,
            String stateVal, String cityVal, String zip, String mobile) {

	if (gender.equalsIgnoreCase("male")) {
		click(radioBtnMr);
	} else {
		click(radioBtnMrs);
	}
	
	type(password, pass);
	
	new Select(waitForElement(selectDay)).selectByValue(day);
	new Select(waitForElement(selectMonth)).selectByValue(month);
	new Select(waitForElement(selectYears)).selectByValue(year);
	
	type(firstName, fname);
	type(lastName, lname);
	type(companyName, company);
	
	type(address1, addr1);
	type(address2, addr2);
	
	new Select(waitForElement(countrySelect)).selectByVisibleText(country);
	
	type(state, stateVal);
	type(city, cityVal);
	type(zipCode, zip);
	type(mobileNo, mobile);
	
	click(createAccount);
	}
	
	//Validation
	public String getAccountCreatedMessage() {
        return waitForElement(accountCreatedMsg).getText();
    }

    public void clickContinue() {
        click(continueBtn);
    }
}
