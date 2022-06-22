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

public class RegistrationPageTest{
    WebDriver driver;
    HomePage homepage;
    LogInPage logInPage;
    SignUpPage signUpPage;
    MyAccountPage myAccountPage;
    @BeforeSuite
    public void launchReport() {
        setUpReport("RegistrationPageTest.html");
    }

    @BeforeTest
    public void browserLauncher() {
        // here you can change the browser
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.alexandnova.com/");

    }

    @Test(priority = 1) //Test Case TC0001 --New User Registration page
    public void verifyLoginPageIsOpened() throws IOException {
        RunReports.test = RunReports.extent.createTest("verifyLoginPageIsOpened", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0001-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0001-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickLoginLink();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0001-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0001-image2.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        logInPage=new LogInPage(driver);
        logInPage.clickRegisterButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0001-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0001-image3.jpg");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.alexandnova.com/account/register");


    }
    @Test(priority = 4) //Test Case TC0002 --Verify Register New User..
    public void verifyRegisterNewUserWithValidData() throws IOException, InterruptedException {

        RunReports.test = RunReports.extent.createTest("verifyRegisterNewUserWithValidData", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0002-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0002-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickLoginLink();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0002-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0002-image2.jpg");
        logInPage=new LogInPage(driver);
        logInPage.clickRegisterButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0002-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0002-image3.jpg");
        signUpPage=new SignUpPage(driver);
        signUpPage.enterFirstAndLastName("hend","ooo");
        signUpPage.enterEmail("hend11505761011@gmail.com");
        signUpPage.enterPswdText("12345678");
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0002-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0002-image4.jpg");
        signUpPage.clickRegisterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0002-image5.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0002-image5.jpg");
        myAccountPage=new  MyAccountPage(driver);
        myAccountPage.clickMyAccountLink();
        Thread.sleep(60000);

        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0002-image6.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0002-image6.jpg");

        Assert.assertTrue(myAccountPage.getWelcomeMessage().toLowerCase().contains("welcome"));
       // Assert.assertTrue(myAccountPage.myAccountLinkIsDisplayed());
        myAccountPage.hooverMyAccountLink();
       myAccountPage.clickLogOutLink();
    }
    @Test(priority = 2) //Test Case TC0003 --Email validation.
    public void verifyEmailValidationForRegister() throws IOException, InterruptedException {

        RunReports.test = RunReports.extent.createTest("verifyEmailValidationForRegister", "Failed,It should shows invalid email but it showed descriptive message");
        String email="hendgmail.com";
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0003-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0003-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickLoginLink();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0003-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0003-image2.jpg");
        logInPage=new LogInPage(driver);
        logInPage.clickRegisterButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0003-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0003-image3.jpg");
        signUpPage=new SignUpPage(driver);
        signUpPage.enterFirstAndLastName("hend","ooo");
        signUpPage.enterEmail(email);
        signUpPage.enterPswdText("12345678");
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0003-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0003-image4.jpg");
        signUpPage.clickRegisterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0003-image5.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0003-image5.jpg");
        Thread.sleep(60000);
        Assert.assertTrue(signUpPage.GetErrorText().toLowerCase().contains("invalid email"));


    }
    @Test(priority = 3) //Test Case TC0004 --Required  / mandatory fields
    public void verifyRegisterWithMissingReqData() throws IOException, InterruptedException {

        RunReports.test = RunReports.extent.createTest("verifyRegisterWithMissingReqData", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0004-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0004-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickLoginLink();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0004-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0004-image2.jpg");
        logInPage=new LogInPage(driver);
        logInPage.clickRegisterButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0004-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0004-image3.jpg");
        signUpPage=new SignUpPage(driver);
        signUpPage.enterFirstAndLastName("","");
        signUpPage.enterEmail("");
        signUpPage.enterPswdText("");
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0004-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0004-image4.jpg");
        signUpPage.clickRegisterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0004-image5.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0004-image5.jpg");
        Thread.sleep(60000);
        Assert.assertEquals(signUpPage.GetErrorText().toLowerCase(),"sorry! please try that again.");


    }
    @Test(priority = 5) //Test Case TC0005 --Verify if the password required rules are not satisfied in the password.
    public void verifyPswdValidationForRegister() throws IOException, InterruptedException {

        RunReports.test = RunReports.extent.createTest("verifyPswdValidationForRegister", "Fail, it should shows invalid password but it created the account with invalid password");
        String pswd="passw";
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0005-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0005-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickLoginLink();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0005-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0005-image2.jpg");
        logInPage=new LogInPage(driver);
        logInPage.clickRegisterButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0005-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0005-image3.jpg");
        signUpPage=new SignUpPage(driver);
        signUpPage.enterFirstAndLastName("hend","ooo");
        signUpPage.enterEmail("email567198011@gmail.com");
        signUpPage.enterPswdText(pswd);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0005-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0005-image4.jpg");
        signUpPage.clickRegisterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0005-image5.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0005-image5.jpg");
        Thread.sleep(20000);
        //Assert.assertEquals(signUpPage.GetErrorText().toLowerCase(),"sorry! please try that again.");
       myAccountPage=new MyAccountPage(driver);
       Assert.assertFalse(myAccountPage.myAccountLinkIsDisplayed());




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
