package test.store.sprig;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.store.sprig.BaseClass;
import page.store.sprig.CreateLoginPage;
import utilities.store.sprig.ExcelUtilClass;

public class CreateLoginPageTest extends BaseClass{
	
	//TESTCASE 1
	@Test
	public void createAnAccount() {
		test = extent.createTest("Create an account");
		
		CreateLoginPage lp = new CreateLoginPage(driver);
		lp.loginFromHomeClick();
		lp.createAnAccountClick();
		lp.setValuesForCreateAccount("Peter", "Honda", "peterhonda@gmail.com", "123@peter");
		lp.submit();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Account - Sprig";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	//TESTCASE 2
	@Test
	public void loginTestUsingValidCred() {
		
		test = extent.createTest("Login test validation using valid credentials");
		
		CreateLoginPage lp = new CreateLoginPage(driver);
		
		String xl = "C:\\Users\\GAM\\Desktop\\Luminar\\Automation Project\\LoginCred.xlsx";
		
		String sheet = "Sheet1";
		
		int rowCount = ExcelUtilClass.getRowCount(xl, sheet);
		
		lp.loginFromHomeClick();
		
		for(int i=1; i<=rowCount; i++) {
			String userName = ExcelUtilClass.getCellValue(xl, sheet, i, 0);
			System.out.println("Username---" + userName);
			
			String passWord = ExcelUtilClass.getCellValue(xl, sheet, i, 1);
			System.out.println("Password---" + passWord);
			
			
			lp.setLoginValues(userName, passWord);
			lp.login();
			
			
		}
		String actualTitle = driver.getTitle();
		String expectedTitle = "My account";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	//TESTCASE 3
	@Test
	public void loginTestUsingInvalidCred() {
		test = extent.createTest("Login test validation using invalid credentials");
		
		CreateLoginPage lp = new CreateLoginPage(driver);
		
		String xl = "C:\\Users\\GAM\\Desktop\\Luminar\\Automation Project\\LoginCred.xlsx";
		
		String sheet = "Sheet2";
		
		int rowCount = ExcelUtilClass.getRowCount(xl, sheet);
		
		lp.loginFromHomeClick();
		
		for(int i=1; i<=rowCount; i++) {
			String userName = ExcelUtilClass.getCellValue(xl, sheet, i, 0);
			System.out.println("Username---" + userName);
			
			String passWord = ExcelUtilClass.getCellValue(xl, sheet, i, 1);
			System.out.println("Password---" + passWord);
			
			
			lp.setLoginValues(userName, passWord);
			lp.login();
				
		}
		
		String incorrectEmailPasswordText = lp.incorrectEmailPassword.getText();
		Assert.assertEquals(incorrectEmailPasswordText, "Incorrect email or password.");
		
	}
	
	
	//TESTCASE 4 
	@Test
	public void loginLinkValidation() throws Exception {
		test = extent.createTest("Login link validation");
		
		CreateLoginPage lp = new CreateLoginPage(driver);
	
		URL obj = new URL(lp.loginPageUrl);
		
		HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		
		int code = con.getResponseCode();
		
		Assert.assertEquals(code, 200);
	}
	
	//TESTCASE 5
	@Test
	public void loginButtontextValidation() throws Exception {
		test = extent.createTest("Login button text validation");
		
		CreateLoginPage lp = new CreateLoginPage(driver);
		
		lp.loginFromHomeClick();
		lp.scrollToElement();
		Thread.sleep(6000);
		
		String actualLoginButtonText = lp.loginButton.getText();
		String expectedLoginButtonText = "Log in";
		
		Assert.assertEquals(actualLoginButtonText, expectedLoginButtonText);
	}
	
	//TESTCASE 5
	@Test
	public void createAnAccountButtontextValidation() {
		test = extent.createTest("Create an account button text validation");
				
		CreateLoginPage lp = new CreateLoginPage(driver);
		lp.loginFromHomeClick();
		lp.scrollToElement();
		
		String actualLoginButtonText = lp.loginButton.getText();
		String expectedLoginButtonText = "Create an Account";
				
		Assert.assertEquals(actualLoginButtonText, expectedLoginButtonText);
		}
	
	//TESTCASE 6
	@Test
	public void submitButtontextValidation() throws Exception {
		test = extent.createTest("Submit button text validation");
		
		CreateLoginPage lp = new CreateLoginPage(driver);
		lp.loginFromHomeClick();
		
		
		lp.createAnAccountClick();
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,600)", "");
		String actualSubmitbuttontext = lp.submitButton.getText();
		String expectedSubmitbuttontext = "Submit";
		
		Assert.assertEquals(actualSubmitbuttontext, expectedSubmitbuttontext);
	}
	
	
	//TESTCASE 7
	@Test
	public void signinOptionsLinkValidation() {
		test = extent.createTest("Signin link validation");
		CreateLoginPage lp = new CreateLoginPage(driver);
		
		lp.loginFromHomeClick();
		lp.createAnAccountClick();
		lp.signLinksValid();
	}
	
	
	//TESTCASE 8
	@Test
	
	public void forgotPassword() {
		test = extent.createTest("Forgot password validation");
		CreateLoginPage lp = new CreateLoginPage(driver);
		
		lp.loginFromHomeClick();
		lp.forgotPasswordClick();
		lp.emailEnter("gibialex977@gmail.com");
		lp.submitRecoveryEmail();
		
		Boolean s = lp.successMessage.isDisplayed();
		Assert.assertEquals(s, true);
	}

}
