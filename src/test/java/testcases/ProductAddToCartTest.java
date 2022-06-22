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
import pages.CartPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductDetailsPage;

import java.io.IOException;
import java.time.Duration;

import static library.RunReports.setUpReport;

public class ProductAddToCartTest {
    WebDriver driver;
    HomePage homepage;
    PaymentPage paymentPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;

    @BeforeSuite
    public void launchReport() {
        setUpReport("ProductAddToCartTest.html");
    }

    @BeforeTest
    public void browserLauncher() {
        // here you can change the browser
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.alexandnova.com/");
    }

    @Test(priority = 1) //Test Case TC0010 --Verify the prices must show up for products on the product page
    public void verifyProductPriceIsDisplayed() throws IOException {
        RunReports.test = RunReports.extent.createTest("verifyProductPriceIsDisplayed", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0010-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0010-image1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homepage.clickProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0010-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0010-image2.jpg");
        productDetailsPage=new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.productPriceIsDisplayed());
        driver.get("https://www.alexandnova.com/");

    }
    @Test(priority = 2) //Test Case TC0011 -- Add Product to the cart and verify if product Is added to cart page
    public void verifyProductAddedToCart() throws IOException {
        RunReports.test = RunReports.extent.createTest("verifyProductAddedToCart", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0011-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0011-image1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0011-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0011-image2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0011-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0011-image3.jpg");
        jse.executeScript("scroll(0,600)");
        productDetailsPage.clickAddToCartButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0011-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0011-image4.jpg");
        Assert.assertTrue(productDetailsPage.getAddToCartMessage().toLowerCase().contains("has been successfully added to your"));
        productDetailsPage.clickCartCount();
        cartPage=new CartPage(driver);
        cartPage.clearQuantityCart();
        cartPage.selectQuantityCart("0");
        cartPage.clickUpdateCartButton();
        driver.get("https://www.alexandnova.com/");

    }
    @Test(priority = 3) //Test Case TC0012 -- Refresh the page and verify if items are still present in the cart
    public void verifyCartAfterRefreshPage() throws IOException, InterruptedException {
        RunReports.test = RunReports.extent.createTest("verifyCartAfterRefreshPage", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0012-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0012-image1.jpg");
       JavascriptExecutor jse = (JavascriptExecutor) driver;
        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0012-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0012-image2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0012-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0012-image3.jpg");
       jse.executeScript("scroll(0,600)");
        productDetailsPage.clickAddToCartButton();
        Thread.sleep(3000);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0012-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0012-image4.jpg");
        driver.navigate().refresh();

        Assert.assertEquals(productDetailsPage.getProductQuantity(),productDetailsPage.getCartCount());
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0012-image5.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0012-image5.jpg");
        productDetailsPage.clickCartCount();
        Thread.sleep(3000);
        cartPage=new CartPage(driver);
        cartPage.clearQuantityCart();
        cartPage.selectQuantityCart("0");
        cartPage.clickUpdateCartButton();
        driver.get("https://www.alexandnova.com/");

    }
    @Test(priority = 4) //Test Case TC0013 and Test Case TC0014-- Increase the quantity of the product and verify if it is showing up in cart
    public void verifyCartAfterIncreasingQuantity() throws IOException, InterruptedException {
        RunReports.test = RunReports.extent.createTest("verifyCartAfterIncreasingQuantity", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0013-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0013-image1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0013-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0013-image2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();
        productDetailsPage.selectProductQuantity("2");
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0013-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0013-image3.jpg");
        jse.executeScript("scroll(0,600)");
        productDetailsPage.clickAddToCartButton();
        Thread.sleep(6000);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0013-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0013-image4.jpg");
        Assert.assertEquals(productDetailsPage.getProductQuantity(),productDetailsPage.getCartCount());

        driver.get("https://www.alexandnova.com/");

    }
    @Test(priority = 5) //Test Case TC0015 -- Remove Product from cart: Verify that the Product should be removed from the cart and the Cart icon should show 0 items.
    public void verifyCartAfterRemovingProducts() throws IOException, InterruptedException {
        RunReports.test = RunReports.extent.createTest("verifyCartAfterRemovingProducts", "Test Pass");
        homepage = new HomePage(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0015-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0015-image1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homepage.clickProduct();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0015-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0015-image2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.clickpPoductSize();
        productDetailsPage.selectProductColor();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0015-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0015-image3.jpg");
        jse.executeScript("scroll(0,600)");
        productDetailsPage.clickAddToCartButton();
        Thread.sleep(6000);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0015-image4.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0015-image4.jpg");
        productDetailsPage.clickCartCount();
        Thread.sleep(3000);
        cartPage=new CartPage(driver);
        cartPage.clearQuantityCart();
        cartPage.selectQuantityCart("0");
        cartPage.clickUpdateCartButton();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0015-image5.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0015-image5.jpg");
        Assert.assertEquals(productDetailsPage.getCartCount(),"0");

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
