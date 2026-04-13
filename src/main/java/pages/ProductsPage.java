package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BasePage;

public class ProductsPage extends BasePage{	
	By productsMenu=By.xpath("//a[contains(text(),'Products')]");
	By allProductsTitle=By.xpath("//h2[contains(text(),'All Products')]");
	
	By searchBox=By.id("search_product");
	By searchBtn=By.id("submit_search");
	By searchedProductsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");
	
	By firstProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
	
	By continueShoppingBtn=By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	By viewCartBtn=By.xpath("//u[normalize-space()='View Cart']");
	
	By womenCategory = By.xpath("//a[@href='#Women']");
	By dressCategory = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
    
    By categoryProducts = By.xpath("//div[@class='product-image-wrapper']");
    
    By productName = By.xpath("//div[@class='product-information']//h2");
    By productPrice = By.xpath("//div[@class='product-information']//span/span");
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void clickProductsMenu() {
		click(productsMenu);
	}

	// Validation
	public boolean isProductsPageDisplayed() { 
		return waitForElement(allProductsTitle).isDisplayed();
	}

	public void searchProduct(String text) {
		type(searchBox, text);
        click(searchBtn);
	}
	
	public boolean isSearchResultDisplayed() {
		return isElementPresent(searchedProductsTitle);
    }
	
	public void clickFirstProduct() {
        click(firstProduct);
    }

    public void clickContinueShopping() {
        click(continueShoppingBtn);
    }

    public void clickViewCartBtn() {
        click(viewCartBtn);
    }
    
	
    public void addProductToCart(String productName) {
        By product = By.xpath("//p[contains(text(),'" + productName + "')]/ancestor::div[@class='product-image-wrapper']");
        By addBtn = By.xpath("//p[contains(text(),'" + productName + "')]/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'Add to cart')]");

        Actions act = new Actions(driver);
        act.moveToElement(waitForElement(product)).perform();

        WebElement btn = waitForElement(addBtn);
        btn.click();
    }
    
    
    public void clickWomenCategory() {
        WebElement element = waitForElement(womenCategory);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public void clickDressCategory() {
        WebElement element = waitForElement(dressCategory);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }
    
    
    public String getProductPrice(String productName) {
        By price = By.xpath("//p[contains(text(),'" + productName + "')]/ancestor::div[@class='product-image-wrapper']//h2");
        return waitForElement(price).getText();
    }

    public boolean isCategoryProductsDisplayed() {
        return driver.findElements(categoryProducts).size() > 0;
    }
    
    public boolean isProductNameDisplayed() {
        return isElementPresent(productName);
    }

    public boolean isProductPriceDisplayed() {
        return isElementPresent(productPrice);
    }
}
