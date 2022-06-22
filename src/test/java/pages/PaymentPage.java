package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="/html/body/div[1]/div/div/header/nav/ol/li[3]")
    WebElement paymentLabel;
    @FindBy(id ="checkout_reduction_code")
    WebElement giftCardText;
    @FindBy(id ="checkout_submit")
    WebElement giftCardButton;
    @FindBy(xpath="//*[@id=\"order-summary\"]/div/div[2]/div/div/form/div/span/span/span")
    WebElement giftCardLabel;
    @FindBy(id="checkout_payment_gateway_66130411573")
    WebElement shopByOption;
    @FindBy(id="checkout_payment_gateway_14059175993")
    WebElement payPalOption;
    @FindBy(id="checkout_payment_gateway_14059208761")
    WebElement creditCardOption;

    @FindBy(linkText ="Log in")
    WebElement logIn;
    @FindBy(id ="checkout_shipping_address_address1")
    WebElement shippingAddressText;
    @FindBy(id ="checkout_shipping_address_city")
    WebElement shippingAddressCityText;
    @FindBy(id ="checkout_shipping_address_zip")
    WebElement shippingAddressZipText;

    @FindBy(id ="continue_button")
    WebElement contButton;
    @FindBy(id ="error-for-address1")
    WebElement errorAddressMessage;

    @FindBy(id ="error-for-city")
    WebElement errorCityMessage;
    @FindBy(id ="error-for-zip")
    WebElement errorZipMessage;

    @FindBy(id ="main-header")
    WebElement paymentLabel2;
    @FindBy(css="#continue_button > span")
    WebElement payNowButton;
    @FindBy(id="checkout_email")
    WebElement checkOutEmail;
    @FindBy(id="checkout_shipping_address_first_name")
    WebElement checkOutFName;
    @FindBy(id="checkout_shipping_address_last_name")
    WebElement checkOutLName;


    public String getPaymentLabel()
    {

        return paymentLabel.getText();
    }
    public void selectGiftCardText(String arg1)
    {

        giftCardText.sendKeys(arg1);
    }
    public void selectCheckOutEmail(String arg1)
    {

        checkOutEmail.sendKeys(arg1);
    }
    public void clearCheckOutEmail()
    {

        checkOutEmail.clear();
    }
    public void selectCheckOutFName(String arg1)
    {

        checkOutFName.sendKeys(arg1);
    }
    public void clearCheckOutFName()
    {

        checkOutFName.clear();
    }
    public void selectCheckOutLName(String arg1)
    {

        checkOutLName.sendKeys(arg1);
    }
    public void clearCheckOutLName()
    {

        checkOutLName.clear();
    }
    public void selectShippingAddressText(String arg1)
    {

        shippingAddressText.sendKeys(arg1);
    }
    public void clearShippingAddressText()
    {

        shippingAddressText.clear();
    }
    public boolean errorAddressMessageIsDisplayed()
    {

        return errorAddressMessage.isDisplayed();
    }
    public void selectShippingAddressCityText(String arg1)
    {

        shippingAddressCityText.sendKeys(arg1);
    }
    public void clearShippingAddressCityText()
    {

        shippingAddressCityText.clear();
    }
    public boolean errorCityMessageIsDisplayed()
    {

        return errorCityMessage.isDisplayed();
    }
    public void selectShippingAddressZipText(String arg1)
    {

        shippingAddressZipText.sendKeys(arg1);
    }
    public void clearShippingAddressZipText()
    {

        shippingAddressZipText.clear();
    }
    public boolean errorZipMessageIsDisplayed()
    {

        return errorZipMessage.isDisplayed();
    }
    public void clickGiftCardButton()
    {

        giftCardButton.click();
    }
    public void clickContButton()
    {

        contButton.click();
    }
    public boolean giftCardLabelIsDisplayed()
    {

        return giftCardLabel.isDisplayed();
    }
    public boolean shopByOptionIsDisplayed()
    {

        return shopByOption.isDisplayed();
    }
    public boolean payPalOptionIsDisplayed()
    {

        return payPalOption.isDisplayed();
    }
    public boolean creditCardOptionIsDisplayed()
    {

        return creditCardOption.isDisplayed();
    }
    public boolean payNowButtonIsDisplayed()
    {

        return payNowButton.isDisplayed();
    }

    public void clickLogIn()
    {

        logIn.click();
    }
    public boolean paymentLabel2IsDisplayed()
    {

        return paymentLabel2.isDisplayed();
    }
}
