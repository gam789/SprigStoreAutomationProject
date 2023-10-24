package page.store.sprig;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {
	
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//header/div[1]/div[2]/div[3]/div[1]/div[1]/a[1]/span[1]/i[1]")
	WebElement searchIcon;
	@FindBy (xpath = "//header/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/form[1]/input[1]")
	WebElement searchField;
	
	public void search(String item) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		searchIcon.click();
		searchField.sendKeys(item);
		searchField.sendKeys(Keys.ENTER);
		
	}
	
	@FindBy (xpath = "//*[@id=\"products-grid\"]/div[1]/div/div[1]/div[2]/div/div/form/button") WebElement addToCartFromProductImage;
	@FindBy (xpath = "//*[@id=\"main-top-nav\"]/div/div/ul/li[1]/a/span") WebElement home;
	@FindBy (xpath = "//header/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/a[1]/i[1]") WebElement cart;
	@FindBy (xpath = "//span[contains(text(),'Checkout')]") WebElement checkout;
	
	public void homeCheckout() {
		search("iphone 14");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		addToCartFromProductImage.click();
	}
	
	@FindBy (xpath = "//*[@id=\"shopify-section-template--18012033057044__main\"]/div/div/div/div/div/div/form/div/div[1]/div[1]/table/tbody/tr[1]/td[4]/div/div/div[1]/i")
	WebElement plusButton;
	public @FindBy (xpath = "//tbody/tr[1]/td[5]/span[1]")WebElement priceValue;
	public @FindBy(xpath = "//span[contains(text(),'Update Shopping Cart')]") WebElement updateCart;
	
	public void incrementQuantity() {
		plusButton.click();
	}
	
	//Used along with above method
	public void updateCartClick() {
		updateCart.click();
	}
	
	@FindBy (xpath = "//span[contains(text(),'Continue Shopping')]") WebElement continueShopping;
	public void continueShoppingButtonClick() {
		continueShopping.click();
		
	}
	
	
	@FindBy (xpath = "//*[@id=\"address_province\"]") WebElement stateDropDownElement;
	
	public void stateDropDown() {
		Select state = new Select(stateDropDownElement);
		state.selectByValue("Kerala");
	}
	
	@FindBy (xpath = "//*[@id=\"address_zip\"]") WebElement pincodeField;
	
	public void pincodeEnter(String pin) {
		pincodeField.sendKeys(pin);
	}
	
	@FindBy (xpath = "//*[@id=\"wrapper-resquest\"]/div/input") WebElement getAQuote;
	
	public void getAQuoteClick() {
		getAQuote.click();
	}
	
	@FindBy (xpath = "//*[@id=\"shopify-section-template--18012033057044__main\"]/div/div/div/div/div/div/form/div/div[2]/div/div/div/button")
	WebElement proceedToCheckOut;
	
	public void proceedToCheckoutClick() {
		proceedToCheckOut.click();
	}
	
	
	
	
	
	
	
}
