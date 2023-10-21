package page.store.sprig;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLoginPage {
	
	WebDriver driver;
	
	
	//CREATE AN ACCOUNT_LOGIN PAGE
	@FindBy (id = "FirstName") WebElement firstNameField;
	@FindBy (id = "LastName") WebElement lastNameField;
	@FindBy (id = "Email") WebElement emailField;
	@FindBy (id = "CreatePassword") WebElement passwordField;
	@FindBy (xpath = "//*[@id=\"create_customer\"]/div/div/div/div/ul/li[5]/button") WebElement submitButton;
	@FindBy (xpath = "//*[@id=\"customer_login\"]/ul/li[5]/button") WebElement createAnAccountButton;
	
	public void createAnAccountClick() {
		createAnAccountButton.click();
	}
	
	public void setValuesForCreateAccount(String firstNameValue, String lastNameValue, String emailValue, String passwordValue) {
		firstNameField.sendKeys(firstNameValue);
		lastNameField.sendKeys(lastNameValue);
		emailField.sendKeys(emailValue);
		passwordField.sendKeys(passwordValue);
	}
	
	public void submit() {
		submitButton.click();
	}
	
	
	@FindBy (xpath = "//*[@id=\"shopify-section-footer\"]/footer/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/ul/li[3]/a")
	WebElement loginFromHome;
	
	@FindBy (id = "CustomerEmail") WebElement userNameField;
	@FindBy (id = "CustomerPassword") WebElement passWordField;
	public @FindBy (xpath = "//*[@id=\"customer_login\"]/ul/li[4]/button") WebElement loginButton;
	
	public @FindBy (xpath = "//*[@id=\"customer_login\"]/div/ul/li") WebElement incorrectEmailPassword;
	
	public String loginPageUrl = "https://sprig.store/account/login?checkout_url=%2F30943714%2Fcheckouts%2F7c8c7236b5bf4beb7e1aeb9c95f86a59";
	
	
	
	public CreateLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginFromHomeClick() {
		loginFromHome.click();
	}
	
	public void setLoginValues(String userName, String passWord) {
		userNameField.clear();
		userNameField.sendKeys(userName);
		passWordField.clear();
		passWordField.sendKeys(passWord);
	}
	
	public void login() {
		loginButton.click();
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("argumets[0].scrollIntoView()", element);
			
	}
}
