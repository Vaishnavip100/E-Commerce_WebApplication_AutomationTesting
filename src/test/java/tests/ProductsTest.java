package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductsPage;

public class ProductsTest extends BaseTest{

	//Search Product
	@Test
	public void searchProductTest() {
	    ProductsPage pp = new ProductsPage(getDriver());
	    pp.clickProductsMenu();

	    Assert.assertTrue(pp.isProductsPageDisplayed(),"Products page not loaded");

	    pp.searchProduct("Top");

	    Assert.assertTrue(pp.isSearchResultDisplayed(),"Search results not displayed");
	}
	
	//Category Navigation
	@Test
	public void categoryNavigationTest() {
	    ProductsPage pp = new ProductsPage(getDriver());
	    pp.clickProductsMenu();
	    	    
	    pp.clickWomenCategory();
	    pp.clickDressCategory();

	    Assert.assertTrue(pp.isCategoryProductsDisplayed(),"Category products not displayed");
	}
	
	//Product Detail Verification
	@Test
	public void productDetailTest() {
	    ProductsPage pp = new ProductsPage(getDriver());
	    pp.clickProductsMenu();
	    pp.clickFirstProduct();

	    Assert.assertTrue(pp.isProductNameDisplayed(),"Product name not displayed");

	    Assert.assertTrue(pp.isProductPriceDisplayed(),"Product price not displayed");
	}
}
