package pages;

import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

 //   @FindBy(linkText = "Sabrina Plush Skirt Leggings")
 //   WebElement productLink;
    @FindBy(xpath = "//*[@id=\"shopify-section-section-2\"]/section/div/article[2]")
    WebElement productLink;
    @FindBy(id = "customer_login_link")
    WebElement loginLink;
    @FindBy(id = "ispbxii_0")
    WebElement searchText;
    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/section/header/div[2]/div[4]/form/input[2]")
    WebElement searchIcon;
    @FindBy(xpath = "//*[@id=\"keyboard-nav-3\"]/h1/span[2]")
    WebElement searchResultText;
    @FindBy(xpath = "//*[@id=\"isp_search_results_container\"]/li[1]")
    WebElement secondSearchResultText;



    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void clickProduct() {

        productLink.click();

    }
    public void clickLoginLink() {

        loginLink.click();

    }

    public void clickSearchText(String arg1) {

        searchText.sendKeys(arg1);

    }

    public void submitSearch() {

        searchIcon.click();

    }
    public String getSearchResultText() {

        return searchResultText.getText();

    }
    public String getSecondSearchResultText() {

        return secondSearchResultText.getText();

    }


    public void clearSearchText() {

        searchText.clear();

    }


}
