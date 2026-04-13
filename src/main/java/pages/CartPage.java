package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage{	
	By removeItemBtn=By.xpath("//a[contains(@class,'cart_quantity_delete')]");
    By emptyMsg = By.xpath("//b[contains(text(),'Cart is empty')]");
    
	By proceedBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	By cartCount = By.xpath("//a[contains(@href,'view_cart')]/span");
	
	public By productName(String name) {
        return By.xpath("//a[contains(text(),'" + name + "')]");
    }
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickRemoveItem() {
		click(removeItemBtn);
        waitForElement(emptyMsg);
	}
	
	public void clickProceedBtn() {
		click(proceedBtn);
	}
	
	// Validations
    public boolean isProductPresent(String productName) {
    	return isElementPresent(By.xpath("//a[contains(text(),'" + productName + "')]"));
    }

    public boolean isCartEmpty() {
    	 return isElementPresent(emptyMsg);
    }
    
    public String getProductPrice(String productName) {
        By price = By.xpath("//td[@class='cart_description']//a[contains(text(),'" + productName + "')]/ancestor::tr//td[@class='cart_price']/p");
        return waitForElement(price).getText();
    }

    public int getCartCount() {
        By products = By.xpath("//tr[contains(@id,'product')]");
        return driver.findElements(products).size();
    }
}
