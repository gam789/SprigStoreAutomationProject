package test.store.sprig;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.store.sprig.BaseClass;
import page.store.sprig.ShoppingCartPage;

public class ShoppingCartTest extends BaseClass{
	
	
	
	@Test
	public void quantityIncreaseCheck() throws Exception {
		test = extent.createTest("Quantity increment check");
		
		ShoppingCartPage s1 = new ShoppingCartPage(driver);
		s1.homeCheckout();
		//System.out.println("Home Checkout");
		s1.incrementQuantity();
		s1.updateCartClick();
		
		String actualValue = s1.priceValue.getText();
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, "Rs. 2,996.00");
		
	}
	
	
	@Test
	public void continueShoppingButtonCheck() throws Exception {
		test = extent.createTest("Contiue shopping button check");
		
		ShoppingCartPage s = new ShoppingCartPage(driver);
		s.homeCheckout();
		s.continueShoppingButtonClick();
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, "Sprig Premium Mobile Accessories.");
		
	}
	
	@Test
	public void proceedToCheckout() {
		test = extent.createTest("Proceed to checkout from cart");
		
		ShoppingCartPage s = new ShoppingCartPage(driver);
		s.homeCheckout();
		s.stateDropDown();
		
		s.pincodeEnter("690100");
		s.getAQuoteClick();
		s.proceedToCheckoutClick();
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, "Checkout - Sprig");
	}

}
