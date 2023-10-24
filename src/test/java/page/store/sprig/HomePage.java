package page.store.sprig;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public @FindBy (xpath = "//header/div[1]/div[2]/div[1]/div[2]/a[1]/img[1]") WebElement homePageLogo;
	
	public Boolean homePageLogoCheck() {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(homePageLogo));
		boolean b = homePageLogo.isDisplayed();
		return b;
	}
	
	
	public void screenShot(WebElement element, String screenshotName) throws Exception {
		
		File companyLogo = homePageLogo.getScreenshotAs(OutputType.FILE);
		org.openqa.selenium.io.FileHandler.copy(companyLogo, new File("C:\\Users\\GAM\\Desktop\\Java\\Eclipse\\SprigstoreAutomationProject\\Screenshots\\" + screenshotName + ".png"));
		
	}
	
	
	@FindBy (xpath = "//*[@id=\"main-top-nav\"]/div/div/ul/li[2]/a/span") WebElement mainStore;
	@FindBy (xpath = "//*[@id=\"main-top-nav\"]/div/div/ul/li[2]/div/div/div[2]/div/div/ul/li[1]/div[2]/ul/li[1]/a") WebElement subStore;
	
	@FindBy (xpath = "//*[@id=\"main-top-nav\"]/div/div/ul/li[3]/a/span") WebElement mainCategory;
	@FindBy (xpath = "//*[@id=\"main-top-nav\"]/div/div/ul/li[3]/div/div/div[2]/div/div/ul/li[1]/a") WebElement subCategory;
	
	public void storeHoverAndSelect() {
		 WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 
		 Actions act = new Actions(driver);
		 
		 act.moveToElement(mainStore).perform();
		 
		 explicitWait.until(ExpectedConditions.visibilityOfAllElements(mainStore));
		 
		 subStore.click();
	}
	
	public void categoryHoverAndSelect() {
		 WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 
		 Actions act = new Actions(driver);
		 
		 act.moveToElement(mainCategory).perform();
		 
		 explicitWait.until(ExpectedConditions.visibilityOfAllElements(mainCategory));
		 
		 subCategory.click();
	}
	
	@FindBy (xpath = "//*[@id=\"sprig-premium-mobile-accessories\"]/div[1]/div/header/div[1]/div[2]/div[3]/div/div[1]/a/span/i")
	WebElement searchIcon;
	@FindBy (xpath = "//*[@id=\"sprig-premium-mobile-accessories\"]/div[1]/div/header/div[1]/div[2]/div[3]/div/div[1]/div/form/input[1]")
	WebElement searchField;
	
	public void search(String item) {
		
		searchIcon.click();
		searchField.sendKeys(item);
		searchField.sendKeys(Keys.ENTER);
		
	}
	
	
	@FindBy (xpath = "//*[@id=\"fc-email\"]") WebElement newsletterField;
	@FindBy (xpath = "//*[@id=\"shopify-section-footer\"]/footer/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/form/div/button")
	WebElement subscribeButton;
	
	public void subscribeToNewsLetterCheck(String newsletterEmail) {
		newsletterField.sendKeys(newsletterEmail);
		subscribeButton.click();
		
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window title:" + driver.getTitle());
		
		Set<String> allWindowsHandles = driver.getWindowHandles();
		
		for(String handle: allWindowsHandles) {
			System.out.println("Handle name:" + handle);
		
			if(!handle.equalsIgnoreCase(parentWindow)) {
				
				driver.switchTo().window(handle);
			}
		
	}
	
	}
	@FindBy (xpath = "//*[@id=\"products-grid\"]/div[1]/div/div[1]/div[2]/div/div/form/button") WebElement addToCartFromProductImage;
	@FindBy (xpath = "//*[@id=\"main-top-nav\"]/div/div/ul/li[1]/a/span") WebElement home;
	@FindBy (xpath = "//header/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/a[1]/i[1]") WebElement cart;
	@FindBy (xpath = "//span[contains(text(),'Checkout')]") WebElement checkout;
	
	public void homeCheckout() {
		search("iphone 14");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		addToCartFromProductImage.click();
		 
		home.click();
		 
		cart.click();
		 
		checkout.click();
		
		
		
	}
	
	
	
}
