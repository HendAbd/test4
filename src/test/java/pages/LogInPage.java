package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver driver;
    @FindBy(css = "#keyboard-nav-3 > div.customer-wrapper > div.new-customer > a")
    WebElement registerButton;
    @FindBy(id = "ispbxii_1")
    WebElement logInEmail;
    @FindBy(id = "ispbxii_2")
    WebElement logInEmail2;

    @FindBy(name = "customer[password]")
    WebElement logInPswd;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[3]/input")
    WebElement logInButton;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[3]/span")
    WebElement forgotPswdLink;
    @FindBy(xpath = "//*[@id=\"ispbxii_2\"]")
    WebElement resetEmailText;
    @FindBy(xpath = "//*[@id=\"keyboard-nav-3\"]/div[2]/div[2]/form/div[2]/input")
    WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"keyboard-nav-3\"]/div[2]/p")
    WebElement resetMessage;




    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterButton() {

        registerButton.click();

    }



    public void clickLogInEmail(String arg1) {

        logInEmail.sendKeys(arg1);

    }
    public void clickLogInEmail2(String arg1) {

        logInEmail2.sendKeys(arg1);

    }


    public void clickLogInPswd(String arg1) {

        logInPswd.sendKeys(arg1);


    }

    public void clickLogInButton() {

        logInButton.click();

    }
    public void clickForgotPswdLink() {

        forgotPswdLink.click();

    }
    public void clickResetEmailText(String arg1) {

        resetEmailText.sendKeys(arg1);

    }

    public void clickResetButton() {

        resetButton.click();

    }
    public String getResetMessage() {

        return resetMessage.getText();

    }



}
