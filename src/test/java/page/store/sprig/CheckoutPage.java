package page.store.sprig;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
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
	
	
	@FindBy (xpath = "//*[@id=\"products-grid\"]/div[1]/div/div[1]/div[2]/div/div/form/button") 
	WebElement addToCartFromImageIcon;
	
	
	public void addToCartFromImage() {
		addToCartFromImageIcon.click();
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
	
	
	@FindBy (xpath = "//input[@id='email']") WebElement emailField;
	@FindBy (xpath = "//input[@id='TextField0']")WebElement firstNameField;
	@FindBy (xpath = "//input[@id='TextField1']")WebElement lastNameField;
	@FindBy (xpath = "//input[@id='TextField2']")WebElement addressField;
	@FindBy (xpath = "//input[@id='TextField3']")WebElement apartmentField;
	@FindBy (xpath = "//input[@id='TextField4']")WebElement cityField;
	@FindBy (xpath = "//input[@id='TextField6']")WebElement phoneField;
	
	public void email(String e) {
		emailField.sendKeys(e);
	}
	
	public void name(String f, String l) {
		firstNameField.sendKeys(f);
		lastNameField.sendKeys(l);
	}
	
	public void address(String houseOrFlatName, String apartmentName, String city) {
		addressField.sendKeys(houseOrFlatName);
		apartmentField.sendKeys(apartmentName);
		cityField.sendKeys(city);
	}
	
	public void phone(String p) {
		phoneField.sendKeys(p);
	}
	
	@FindBy (xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
	WebElement payNowButton;
	
	public void pay() {
		payNowButton.click();
	}
	
	
	@FindBy (xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/select[1]") WebElement stateCheckout;
	public void stateDropDownCheckout() {
		Select stateCheck = new Select(stateCheckout);
		stateCheck.selectByValue("KL");
	}
	
	@FindBy (xpath = "//*[@id=\"TextField5\"]") WebElement pincodeCheckout;
	public void pincodeEnterCheckout(String pin) {
		pincodeCheckout.sendKeys(pin);
		
	}
	
	
}
