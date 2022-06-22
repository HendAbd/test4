package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;


    @FindBy(id = "updates_30999621206069")
    WebElement quantityCart;
    @FindBy(name = "update")
    WebElement updateCartButton;
    @FindBy(name = "checkout")
    WebElement checkOutButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearQuantityCart() {

        quantityCart.clear();

    }
    public void selectQuantityCart(String arg1) {

        quantityCart.sendKeys(arg1);

    }
    public void clickUpdateCartButton() {

        updateCartButton.click();

    }
    public void clickCheckOutButton() {

        checkOutButton.click();

    }



}
