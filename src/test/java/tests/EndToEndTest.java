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

public class EndToEndTest extends BaseTest {

    ConfigReader config = new ConfigReader();

    @Test
    public void endToEndFlowTest() {

        //Open Home Page → Login
        HomePage hp = new HomePage(getDriver());
        LoginPage lp = hp.clickLogin();

        lp.login(config.getEmail(), config.getPassword());

        //Navigate to Products
        ProductsPage pp = new ProductsPage(getDriver());
        pp.clickProductsMenu();

        //Search product
        pp.searchProduct("Top");

        Assert.assertTrue(pp.isSearchResultDisplayed(),
                "Search results not displayed");

        //Add product to cart
        pp.addProductToCart("Blue Top");

        //Go to cart
        pp.clickViewCartBtn();

        CartPage cp = new CartPage(getDriver());

        Assert.assertTrue(cp.isProductPresent("Blue Top"),
                "Product not present in cart");

        // Proceed to checkout
        cp.clickProceedBtn();

        CheckoutPage checkout = new CheckoutPage(getDriver());

        //Add comment
        checkout.enterComment("E2E Test Order");

        //Place order
        checkout.clickPlaceOrder();

        //Enter payment details
        checkout.enterPaymentDetails("Vaishnavi","Perumalla","123","12","2030");

        checkout.clickPay();

        //Final validation
        Assert.assertTrue(checkout.isOrderSuccessful(),
                "E2E flow failed: Order not successful");
        
        checkout.clickContinueAfterOrder();
    }
}