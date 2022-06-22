package testcases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import library.RunReports;
import library.SelectBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static library.RunReports.setUpReport;

public class LoginRegisteredUserTest {
    WebDriver driver;
    HomePage homepage;
    LogInPage logInPage;
    SignUpPage signUpPage;
MyAccountPage myAccountPage;
    @BeforeSuite
    public void launchReport() {
        setUpReport("LoginRegisteredUserTest.html");
    }

    @BeforeTest
    public void browserLauncher() {
        // here you can change the browser
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.alexandnova.com/");

    }

    @Test(priority = 2) //Test Case TC0006 --Login Page user
    public void verifyLoginUserWithValidData() throws IOException, InterruptedException {

        RunReports.test = RunReports.extent.createTest("verifyRegisterNewUserWithValidData", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0006-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0006-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickLoginLink();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0006-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0006-image2.jpg");
        logInPage=new LogInPage(driver);
        logInPage.clickLogInEmail("hend112@gmail.com");
        logInPage.clickLogInPswd("12345678");
        logInPage.clickLogInButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0006-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0006-image3.jpg");
        myAccountPage=new MyAccountPage(driver);
        Thread.sleep(60000);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0006-image6.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0006-image6.jpg");
        Assert.assertTrue(myAccountPage.myAccountLinkIsDisplayed());
      //  myAccountPage.clickLogOutLink();
    }
    @Test(priority = 1) //Test Case TC0007 --Verify when passing incorrect Email and correct password to Login page
    public void verifyLoginUserWithInValidData() throws IOException, InterruptedException {

        RunReports.test = RunReports.extent.createTest("verifyLoginUserWithInValidData", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0007-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickLoginLink();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0007-image2.jpg");
        logInPage=new LogInPage(driver);
        logInPage.clickLogInEmail("hend@gmail.com");
        logInPage.clickLogInPswd("12345678");
        logInPage.clickLogInButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0007-image3.jpg");
        signUpPage=new SignUpPage(driver);
        Thread.sleep(60000);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007-image6.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0007-image6.jpg");
        Assert.assertEquals(signUpPage.GetErrorText().toLowerCase(),"sorry! please try that again.");


    }
    @AfterMethod
    public void getResult(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            RunReports.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));

            RunReports.test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            RunReports.test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            RunReports.test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            RunReports.test.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void closeBrowser() throws IOException {

        RunReports.tearDown();
      driver.quit();

    }

}
