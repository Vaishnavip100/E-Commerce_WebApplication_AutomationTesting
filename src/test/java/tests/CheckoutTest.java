package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    ConfigReader config = new ConfigReader();

    // Complete Checkout Flow (with login)
    @Test
    public void completeCheckoutFlow() {

        HomePage hp = new HomePage(getDriver());
        LoginPage lp = hp.clickLogin();

        lp.login(config.getEmail(), config.getPassword());
		
		ProductsPage pp=new ProductsPage(getDriver());
		pp.clickProductsMenu();
		pp.addProductToCart("Blue Top");
		pp.clickViewCartBtn();
		
		CartPage cp=new CartPage(getDriver());
        cp.clickProceedBtn();
        
        CheckoutPage checkout = new CheckoutPage(getDriver());
        checkout.enterComment("Good");
        checkout.clickPlaceOrder();
        checkout.enterPaymentDetails("Vaishnavi", "Perumalla", "089", "11", "2030");
        checkout.clickPay();
        
        // Validation
        Assert.assertTrue(checkout.isOrderSuccessful(), "Order was not successful");
    }
    
    // Checkout without login
    @Test
    public void checkoutWithoutLogin() {
        ProductsPage pp = new ProductsPage(getDriver());
        pp.clickProductsMenu();
        pp.addProductToCart("Winter Top");
        pp.clickViewCartBtn();
        
        CartPage cp = new CartPage(getDriver());
        cp.clickProceedBtn();
        
        CheckoutPage checkout = new CheckoutPage(getDriver());
        
        // Validate Register/Login option
        Assert.assertTrue(checkout.isRegisterLoginVisible(),"User not prompted to login before checkout");
        checkout.clickRegisterLogin();
    }
}