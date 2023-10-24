package test.store.sprig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.store.sprig.BaseClass;
import page.store.sprig.HomePage;

public class HomePageTest extends BaseClass{

	@Test 
	public void homePageLogoPresent() throws Exception {
		test = extent.createTest("Home page logo test");
		HomePage h = new HomePage(driver);
		Boolean b1 = h.homePageLogoCheck();
		
		h.screenShot(h.homePageLogo, "logo");
		
		Assert.assertEquals(b1, true);
	}
	
	
	@Test
	public void store() {
		test = extent.createTest("Store dropdown");
		HomePage h = new HomePage(driver);
		h.storeHoverAndSelect();
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, "iPhone 14 Series - Sprig");
	}
	
	@Test
	public void category() {
		test = extent.createTest("Category dropdown");
		HomePage h = new HomePage(driver);
		h.categoryHoverAndSelect();
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, "Tempered Glass - Sprig");
	}
	
	
	@Test
	public void searchIcon() {
		test = extent.createTest("Search icon test");
		HomePage h = new HomePage(driver);
		h.search("iphone 14");
		
		WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"products-grid\"]/div[1]/div/div[2]/a"));
		searchResult.isDisplayed();
		 
		 Assert.assertEquals(searchResult.isDisplayed(), true);
	}
	
	
	@Test
	public void newsletterCheck() {
		test = extent.createTest("Subscribe to newsletter");
		HomePage h = new HomePage(driver);
		h.subscribeToNewsLetterCheck("abc@gmail.com");
		
		String actualSubscribeTitle = driver.getTitle();
		Assert.assertEquals(actualSubscribeTitle, "Subscription success");
		
	}
	
	@Test
	public void addToCart() {
		test = extent.createTest("Add to cart");
		HomePage h = new HomePage(driver);
		h.homeCheckout();
		
		String actualTitle = driver.getTitle();
		
		
		Assert.assertEquals(actualTitle, "Checkout - Sprig");
	}
	
	
	

}
