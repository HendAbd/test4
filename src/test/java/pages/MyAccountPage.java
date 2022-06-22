package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

public class MyAccountPage {
    WebDriver driver;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;
    @FindBy(xpath = "//*[@id=\"keyboard-nav-3\"]/h1")
    WebElement welcomeMessage;
   // @FindBy(linkText = "Log out")
   // @FindBy(css="#customer_logout_link")

    @FindBy(xpath="//div[@class='customer-links-inner']/ul/li[3]/a")

    WebElement logOutLink;

    @FindBy(xpath="//*[@id=\"isp_search_results_container\"]/li[2]/div[1]/a[1]/img")

    WebElement myProduct;





    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public boolean myAccountLinkIsDisplayed() {

        return myAccountLink.isDisplayed();

    }

    public boolean welcomeMessageIsDisplayed() {

        return welcomeMessage.isDisplayed();

    }

    public String getWelcomeMessage() {

      return   welcomeMessage.getText();

    }
    public void clickLogOutLink() {
      //  List<WebElement> allProduct = driver.findElements(By.xpath("//div[@class='customer-links-inner']/ul"));



        logOutLink.click();

    }
    public String getLogOutLink() {




         return logOutLink.getText();

    }
    public void clickMyAccountLink() {

        myAccountLink.click();

    }
    public void hooverMyAccountLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountLink).perform();

    }



    public void clickMyProduct() {

        myProduct.click();

    }
}
