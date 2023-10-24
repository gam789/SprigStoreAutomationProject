package page.store.sprig;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateLoginPage {
	
	WebDriver driver;
	
	
	//CREATE AN ACCOUNT_LOGIN PAGE
	@FindBy (id = "FirstName") WebElement firstNameField;
	@FindBy (id = "LastName") WebElement lastNameField;
	@FindBy (id = "Email") WebElement emailField;
	@FindBy (id = "CreatePassword") WebElement passwordField;
	public @FindBy (xpath = "//*[@id=\"create_customer\"]/div/div/div/div/ul/li[5]/button") WebElement submitButton;
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
	
	public void scrollToElement() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,400)", "");
			
	}
	
	
	@FindBy (tagName = "a") List<WebElement> signinLinks;
	public void signLinksValid() {
		driver.switchTo().frame("social_login_frame");
		//List<WebElement> signinLinks = driver.findElements(By.tagName("a"));
		ArrayList<String> actualstringArrayList = new ArrayList<String>();
		ArrayList<String> expectedstringArrayList = new ArrayList<String>(Arrays.asList("https://social-login.oxiapps.com/auth/facebook?shop=sprigstore-com.myshopify.com&parenturl=https://sprig.store/account/register", 
					"https://social-login.oxiapps.com/auth/google?shop=sprigstore-com.myshopify.com&parenturl=https://sprig.store/account/register", 
					"https://social-login.oxiapps.com/auth/twitter?shop=sprigstore-com.myshopify.com&parenturl=https://sprig.store/account/register",
					"https://social-login.oxiapps.com/auth/linkedin?shop=sprigstore-com.myshopify.com&parenturl=https://sprig.store/account/register",
					"https://social-login.oxiapps.com/auth?type=amazon&shop=sprigstore-com.myshopify.com&parenturl=https://sprig.store/account/register"));
		for(WebElement link:signinLinks) {
			String s = link.getAttribute("href");
			
			
			
			actualstringArrayList.add(s);
			verify(s);
			
		}
		//System.out.println(actualstringArrayList);
		Assert.assertEquals(actualstringArrayList, expectedstringArrayList);
		System.out.println("Pass");
	}
	
	private void verify(String s) {
		// TODO Auto-generated method stub
		try {
			URL obj = new URL(s);
			//Typecasting
			HttpURLConnection con = (HttpURLConnection)obj.openConnection();
			
			if(con.getResponseCode() == 200) {
				System.out.println("Valid---" +s);
				System.out.println(con.getResponseCode());
			}
			else {
				System.out.println("Broken link---" +s);
				System.out.println(con.getResponseCode());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
	}
	
	@FindBy (xpath = "//*[@id=\"RecoverPassword\"]") WebElement forgotYourPassword;
	@FindBy (xpath = "//*[@id=\"RecoverEmail\"]") WebElement recoveryEmail;
	@FindBy (xpath = "//*[@id=\"RecoverPasswordForm\"]/div/div/div/form/div/ul/li[3]/button")WebElement recoveryEmailSubmit;
	public @FindBy (xpath = "//*[@id=\"ResetSuccess\"]") WebElement successMessage;
	public void forgotPasswordClick() {
		forgotYourPassword.click();
	}
	
	public void emailEnter(String email) {
		recoveryEmail.sendKeys(email);
	}
	
	public void submitRecoveryEmail() {
		recoveryEmailSubmit.click();
	}
	
	
	
	
	
}
