package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.ProductsPage;

public class CartTest extends BaseTest{
	
	//Add product & verify it appears
	@Test
	public void addProductToCartTest() {		
		ProductsPage pp=new ProductsPage(getDriver());
		pp.clickProductsMenu();
		String expectedPrice = pp.getProductPrice("Blue Top");
		pp.addProductToCart("Blue Top");
		pp.clickViewCartBtn();
		
		CartPage cp=new CartPage(getDriver());
		Assert.assertTrue(cp.isProductPresent("Blue Top"),"Product not present in cart");
	    String actualPrice = cp.getProductPrice("Blue Top");

	    Assert.assertEquals(actualPrice, expectedPrice,"Product price mismatch");
	}
	
	//Remove product & verify it disappears
	@Test
	public void removeProductTest(){		
		ProductsPage pp=new ProductsPage(getDriver());
		pp.clickProductsMenu();
		pp.addProductToCart("Summer White Top");
		pp.clickViewCartBtn();
		
		CartPage cp=new CartPage(getDriver());
		cp.clickRemoveItem();
		
		Assert.assertTrue(cp.isCartEmpty(),"Product not removed from cart");
	}
	
	//Verify cart count updates
	@Test
	public void verifyCartCountTest() {
        ProductsPage pp = new ProductsPage(getDriver());
        pp.clickProductsMenu();
        int before = 0;
        pp.addProductToCart("Blue Top");
        pp.clickViewCartBtn();

        CartPage cp = new CartPage(getDriver());
        int after = cp.getCartCount();

        Assert.assertTrue(after > before,"Cart count did not increase");
    }
}
