package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage{	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Register
	By registerBtn=By.xpath("//a[@href='/login']");
	public RegisterPage clickRegister() {
        click(registerBtn);
        return new RegisterPage(driver);
    }

	// Login
    public LoginPage clickLogin() {
        click(registerBtn);
        return new LoginPage(driver);
    }
}
