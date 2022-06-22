package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    WebDriver driver;
    @FindBy(id = "ispbxii_1")
    WebElement firstNameText;
    @FindBy(id = "ispbxii_2")
    WebElement lastNameText;
    @FindBy(css = "#create_customer > div:nth-child(6) > input[type=password]")
    WebElement pswdText;
    @FindBy(id = "ispbxii_3")
    WebElement emailText;
    //@FindBy(css = "#create_customer > div:nth-child(7) > input[type=submit]")
    @FindBy(xpath = " //*[@id=\"create_customer\"]/div[5]/input")
    WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    WebElement notReportCheckbox;
    @FindBy(xpath = "//*[@id=\"keyboard-nav-3\"]/div/form/input[2]")
    WebElement secondRegisterButton;
   // @FindBy(xpath = "//*[@id=\"customer_login\"]/p")
   // WebElement errorLabel;
    @FindBy(css = "#customer_login > p")
    WebElement errorLabel;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   public String GetErrorText() {

        return errorLabel.getText();

    }

    public void enterFirstAndLastName(String arg1, String arg2) {

        firstNameText.sendKeys(arg1);
        lastNameText.sendKeys(arg2);

    }

    public void enterPswdText(String arg1) {

        pswdText.sendKeys(arg1);

    }



    public void enterEmail(String arg1) {

        emailText.sendKeys(arg1);


    }




    public void clickRegisterButton() {

        registerButton.click();

    }

    public void clickSecondRegisterButton() {

        secondRegisterButton.click();

    }


}
