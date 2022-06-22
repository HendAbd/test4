package pages;

import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"bcpo-select-option-0\"]/div[1]/label")
    WebElement productSize;
    @FindBy(xpath = " //*[@id=\"bcpo-select-option-0\"]/div[3]/label")
    WebElement productSize2;

    @FindBy(css= "#alexnova-btn-cont-id > div")
    WebElement buyNow;
    @FindBy(xpath = "//*[@id=\"shopify-section-product\"]/section/div/div[3]/div/p/span[1]")
    WebElement productPrice;
    @FindBy(xpath = "//*[@id=\"product_form_4313722716213\"]/div[4]/input")
    WebElement addToCartButton;

    @FindBy(css ="#product_form_4313722716213 > div.product-message.success-message")
    WebElement addToCartMessage;

    @FindBy(xpath= "//*[@id=\"bcpo-select-option-1\"]/div[2]/label")
    WebElement productColor;
    @FindBy(className= "cart-count-number")
    WebElement cartCount;
    @FindBy(css= "#ispbxii_1")
    WebElement productQuantity;





    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public void clickpPoductSize() {

        productSize.click();

    }


    public void clickBuyNow() {

        buyNow.click();

    }
    public boolean productPriceIsDisplayed() {

        return productPrice.isDisplayed();

    }
    public boolean buyNowIsEnabled() {

        return buyNow.isEnabled();

    }

    public void clickAddToCartButton() {

        addToCartButton.click();

    }
    public String getAddToCartMessage() {

        return addToCartMessage.getText();

    }
    public String getCartCount() {

        return cartCount.getText();

    }
    public void clickCartCount() {

         cartCount.click();

    }
    public String getProductQuantity() {

        return productQuantity.getAttribute("value");

    }
    public  void selectProductQuantity(String arg1) {

         productQuantity.sendKeys(arg1);

    }


    public void selectProductColor() {


        productColor.click();

    }
/*

    public void clickProductImage() {

        productImage.click();

    }



    public void selectSize() {


        Select se = new Select(sizeList);
        se.selectByIndex(2);

    }



    public String colorText() {
        return color.getAttribute("name");


    }

    public String sizeListText() {
        return sizeList.getAttribute("value");


    }

    public void clearquantityWantedText() {

        quantityWanted.clear();


    }

    public String quantityWantedText() {
        return quantityWanted.getAttribute("value");


    }
*/
}
