package testcases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import library.RunReports;
import library.SelectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static library.RunReports.setUpReport;

public class CheckoutProductFromShoppingCartTest {
    WebDriver driver;
    HomePage homepage;
    PaymentPage paymentPage;
    ProductDetailsPage productDetailsPage;
    LogInPage logInPage;
CartPage cartPage;
    @BeforeSuite
    public void launchReport() {
        setUpReport("CheckoutProductFromShoppingCartTest.html");
    }

    @BeforeTest
    public void browserLauncher() {
        // here you can change the browser
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.alexandnova.com/");
    }


    @Test(priority = 1) //Test Case TC00016 --verify that user can apply for a discount code at checkout page
    public void verifyApplyGiftCard() throws IOException, InterruptedException {
        RunReports.test = RunReports.extent.createTest("verifyApplyGiftCard", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00016-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00016-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00016-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00016-image2.jpg");
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();

        productDetailsPage.clickAddToCartButton();
        Thread.sleep(3000);
        productDetailsPage.clickCartCount();
        cartPage=new CartPage(driver);
        cartPage.clickCheckOutButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00016-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00016-image3.jpg");
        paymentPage= new PaymentPage(driver);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        paymentPage.selectGiftCardText("WELCOME10");
        paymentPage.clickGiftCardButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00016-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00016-image4.jpg");
        Assert.assertTrue(paymentPage.giftCardLabelIsDisplayed());


       driver.get("https://www.alexandnova.com/");


    }
    @Test(priority = 3) //Test Case TC00017 --Payment Mode Check
    public void verifyPaymentOptions() throws IOException, InterruptedException {
        RunReports.test = RunReports.extent.createTest("verifyPaymentOptions", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00017-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00017-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00017-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00017-image2.jpg");
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();
        jse.executeScript("scroll(0,600)");
        productDetailsPage.clickAddToCartButton();
        Thread.sleep(3000);
   productDetailsPage.clickCartCount();
        Thread.sleep(3000);
cartPage=new CartPage(driver);
        cartPage.clickCheckOutButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00017-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00017-image3.jpg");
        paymentPage= new PaymentPage(driver);
        paymentPage.clearCheckOutEmail();
        paymentPage.clearCheckOutFName();
        paymentPage.clearCheckOutLName();
        paymentPage.clearShippingAddressText();
        paymentPage.clearShippingAddressCityText();
        paymentPage.clearShippingAddressZipText();
        paymentPage.selectCheckOutEmail("hend2@gmail.com");
        Thread.sleep(2000);
        paymentPage.selectCheckOutFName("hindtest");
        paymentPage.selectCheckOutLName("abdelna");
        paymentPage.selectShippingAddressText("112 main st");
        paymentPage.selectShippingAddressCityText("Thornton");
        paymentPage.selectShippingAddressZipText("80223");
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00017-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00017-image4.jpg");
        paymentPage.clickContButton();
        Thread.sleep(2000);
        paymentPage.clickContButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00017-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00017-image4.jpg");
         Assert.assertTrue(paymentPage.payPalOptionIsDisplayed());
       Assert.assertTrue(paymentPage.shopByOptionIsDisplayed());
      Assert.assertTrue(paymentPage.creditCardOptionIsDisplayed());

        driver.get("https://www.alexandnova.com/");



    }
    @Test(priority = 2) //Test Case TC00018 --Check Out Mandatory Field Validation:Try completing the check-out process by leaving any mandatory field blank in the creditcard payment information and shipping or billing address.
    public void verifyPaymentWithMissingReqData() throws IOException, InterruptedException {
        RunReports.test = RunReports.extent.createTest("verifyPaymentWithMissingReqData", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00018-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00018-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00018-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00018-image2.jpg");
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();
        jse.executeScript("scroll(0,600)");
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.clickCartCount();
        cartPage=new CartPage(driver);
        Thread.sleep(2000);
        cartPage.clickCheckOutButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00018-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00018-image3.jpg");
        paymentPage= new PaymentPage(driver);
        paymentPage.clearCheckOutEmail();
        paymentPage.clearCheckOutFName();
        paymentPage.clearCheckOutLName();
        paymentPage.clearShippingAddressText();
        paymentPage.clearShippingAddressCityText();
        paymentPage.clearShippingAddressZipText();
        paymentPage.selectCheckOutEmail("hend5@gmail.com");
        Thread.sleep(2000);
        paymentPage.selectCheckOutFName("hhhh");
        paymentPage.selectCheckOutLName("ooo");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        paymentPage.selectShippingAddressText("");
        paymentPage.selectShippingAddressCityText("");
        paymentPage.selectShippingAddressZipText("");
        paymentPage.clickContButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00018-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00018-image4.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertTrue(paymentPage.errorAddressMessageIsDisplayed());
        Assert.assertTrue(paymentPage.errorCityMessageIsDisplayed());
        Assert.assertTrue(paymentPage.errorZipMessageIsDisplayed());
        paymentPage.clearCheckOutEmail();
        paymentPage.clearCheckOutFName();
        paymentPage.clearCheckOutLName();
        paymentPage.clearShippingAddressText();
        paymentPage.clearShippingAddressCityText();
        paymentPage.clearShippingAddressZipText();
        driver.get("https://www.alexandnova.com/");

    }
    @Test(priority = 4) //Test Case TC00019 --Verify that the user should successfully checkout the product
    public void verifyCheckOutProductSuccessfully() throws IOException, InterruptedException {
        RunReports.test = RunReports.extent.createTest("verifyCheckOutProductSuccessfully", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00019-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00019-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00019-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00019-image2.jpg");
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();
         JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");

        driver.navigate().refresh();
         productDetailsPage.clickBuyNow();

        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00019-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00019-image3.jpg");
        paymentPage= new PaymentPage(driver);
      paymentPage.selectCheckOutEmail("hend3@gmail.com");
        Thread.sleep(2000);
        paymentPage.selectCheckOutFName("hhhh");
        paymentPage.selectCheckOutLName("ooo");

        paymentPage.selectShippingAddressText("112 main st");
        paymentPage.selectShippingAddressCityText("Thornton");
        paymentPage.selectShippingAddressZipText("80223");
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00019-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00019-image4.jpg");
        paymentPage.clickContButton();
        Thread.sleep(3000);
        paymentPage.clickContButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00019-image5.jpg");
        RunReports.test.addScreenCaptureFromPath("TC00019-image5.jpg");
        Assert.assertTrue(paymentPage.payNowButtonIsDisplayed());
        Assert.assertTrue(paymentPage.paymentLabel2IsDisplayed());
        driver.get("https://www.alexandnova.com/");


    }

 /*  @Test(priority = 5) //Test Case Add-TC3 --Verify that User can purchase a product now without adding to cart
    public void verifyBuyNowWithoutAddToCart() throws IOException, InterruptedException {
        RunReports.test = RunReports.extent.createTest("verifyBuyNowWithoutAddToCart", "Test fail");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/Add-TC3-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("Add-TC3-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
      //  jse.executeScript("scroll(0,600)");
        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/Add-TC3-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("Add-TC3-image2.jpg");
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();
        //  JavascriptExecutor jse = (JavascriptExecutor) driver;
      //  jse.executeScript("scroll(0,600)");
        Thread.sleep(3000);
       Assert.assertTrue(productDetailsPage.buyNowIsEnabled());

    }*/
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
