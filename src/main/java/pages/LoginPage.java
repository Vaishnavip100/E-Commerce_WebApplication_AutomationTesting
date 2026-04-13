package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage{	
	By email=By.xpath("//input[@data-qa='login-email']");
	By password=By.name("password");
	By loginBtn=By.xpath("//button[normalize-space()='Login']");
	By logoutBtn=By.xpath("//a[@href='/logout']");
	
	By loggedInAs=By.xpath("//a[contains(text(),'Logged in as')]");
	By errorMsg=By.xpath("//p[contains(text(),'incorrect')]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String email) {
		type(this.email, email);
	}

	public void setPassword(String password) {
		type(this.password, password);
	}

	public void clickLoginBtn() {
		click(loginBtn);
	}
	
	public void clickLogoutBtn() {
		click(logoutBtn);
	}
	
	public boolean isLoginSuccessful() {
		return isElementPresent(loggedInAs);
	}
	
	public boolean isLoginFailed() {
		return isElementPresent(errorMsg);
	}
	
	public void login(String email, String password) {
		setEmail(email);
		setPassword(password);
		clickLoginBtn();
	}
}
