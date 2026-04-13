package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage extends BasePage {
    By registerLoginLink = By.xpath("//u[contains(text(),'Register / Login')]");

    By commentBox = By.name("message");
    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");

    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By payBtn = By.id("submit");

    By successMsg = By.xpath("//b[contains(text(),'Order Placed')]");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");
    
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // For "checkout without login" scenario
    public void clickRegisterLogin() {
        click(registerLoginLink);
    }

    public void enterComment(String comment) {
        type(commentBox, comment);
    }

    public void clickPlaceOrder() {
        click(placeOrderBtn);
    }

    public void enterPaymentDetails(String name, String card, String cvcCode, String month, String year) {
        type(nameOnCard, name);
        type(cardNumber, card);
        type(cvc, cvcCode);
        type(expiryMonth, month);
        type(expiryYear, year);
    }

    public void clickPay() {
        click(payBtn);
    }
    
    public void clickContinueAfterOrder() {
        click(continueBtn);
    }

    // Validations
    public boolean isOrderSuccessful() {
        return isElementPresent(successMsg);
    }

    public boolean isRegisterLoginVisible() {
        return isElementPresent(registerLoginLink);
    }
}