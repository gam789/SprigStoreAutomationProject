package test.store.sprig;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.store.sprig.BaseClass;
import page.store.sprig.CheckoutPage;

public class CheckoutTest extends BaseClass{
	
	
	@Test
	public void checkoutTest() throws Exception {
		test = extent.createTest("Checkout page test");
		
		CheckoutPage c = new CheckoutPage(driver);
		c.search("iphone 14");
		c.addToCartFromImage();
		c.stateDropDown();
		c.pincodeEnter("682017");
		c.getAQuoteClick();
		c.proceedToCheckoutClick();
		
		c.email("abc@gmail.com");
		c.name("Peter", "Vyog");
		c.address("Peace villa", "Royal complex", "London");
		c.stateDropDownCheckout();
		c.pincodeEnterCheckout("682017");
		c.phone("9585658963");
		
		Thread.sleep(5000);
		
		c.pay();
		
		Thread.sleep(6000);
		String u1 = driver.getCurrentUrl();
		System.out.println(u1);
		String u2 = "https://api.payu.in";
		boolean b = u1.contains(u2);
		Assert.assertEquals(b, true);
		
	}

}
