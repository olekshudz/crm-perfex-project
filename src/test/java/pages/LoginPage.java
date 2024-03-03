package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement loginHeader;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".text-center.alert.alert-danger")
    private WebElement errorMessage;

    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginDisplayed() {
        return loginHeader.isDisplayed();
    }

    public String getErrorMessage() {
        return BrowserUtils.getText(errorMessage);
    }
}
