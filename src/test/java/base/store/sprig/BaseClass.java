package base.store.sprig;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	public static WebDriver driver;
	
	public ExtentHtmlReporter reporter;
	public ExtentTest test;
	public ExtentReports extent;
	
	@BeforeTest
	public void setUp()
	{	
		reporter = new ExtentHtmlReporter("./CreateAndLoginReportFolder/Createloginreport.html");
			reporter.config().setDocumentTitle("Sprig Automation Report");
			reporter.config().setReportName("Functional Test");
			reporter.config().setTheme(Theme.DARK);
			
			
		extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Hostname", "https://sprig.store/");
			extent.setSystemInfo("OS", "Windows10");
			extent.setSystemInfo("Tester name", "Gibi Alex Mathew");
			extent.setSystemInfo("Browser name", "Google Chrome");
		
		//Code to handle notification
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
	}
	
	@BeforeMethod
	public void urlLoading() {
		driver.get("https://sprig.store/");
		
		driver.manage().window().maximize();
	}
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case failed is" + result.getName());
			test.log(Status.FAIL, "Test Case failed is" + result.getThrowable());
			
			String picname = result.getName() + ".png";
			String path = captureScreenShot(picname);
			
			test.addScreenCaptureFromPath(path);
		}
		
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case skipped is" + result.getName());
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test case passed is" + result.getName());
		}
	}
	
	
	public static String captureScreenShot(String fileName) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./CreateAndLoginReportFolder/" + fileName);
		
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return destFile.getAbsolutePath();
	}
	
	
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
	
}
