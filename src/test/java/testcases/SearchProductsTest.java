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
import pages.HomePage;
import pages.LogInPage;

import java.io.IOException;
import java.time.Duration;

import static library.RunReports.setUpReport;

public class SearchProductsTest {
    WebDriver driver;
    HomePage homepage;
    @BeforeSuite
    public void launchReport() {
        setUpReport("SearchProductsTest.html");
    }

    @BeforeTest
    public void browserLauncher() {
        // here you can change the browser
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.alexandnova.com/");

    }


    @Test(priority = 2) //Test Case TC0008 --VCorrect search results should show up for different types such as product name, brand name, or fuzzy search.
    public void verifySearchResultIsMatched() throws IOException {

        RunReports.test = RunReports.extent.createTest("verifySearchResultIsMatched", "Test Pass");
        homepage = new HomePage(driver);
        String searchText="baby shoes";
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0008-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0008-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickSearchText(searchText);
        homepage.submitSearch();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0008-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0008-image2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0008-image3.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0008-image3.jpg");
        Assert.assertTrue(homepage.getSearchResultText().toLowerCase().contains(searchText));
        homepage.clearSearchText();


    }
    @Test(priority = 1) //Test Case TC0009 --Without entering anything in the search box click on the Search button..
    public void verifySearchResultWithNullSearchText() throws IOException {

        RunReports.test = RunReports.extent.createTest("verifySearchResultWithNullSearchText", "Test Pass");
        homepage = new HomePage(driver);
        String searchText="";
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0009-image1.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0009-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homepage.clickSearchText(searchText);
        homepage.submitSearch();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0009-image2.jpg");
        RunReports.test.addScreenCaptureFromPath("TC0009-image2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals(homepage.getSecondSearchResultText(),"No results found. Showing top popular products you might want to consider...");



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
