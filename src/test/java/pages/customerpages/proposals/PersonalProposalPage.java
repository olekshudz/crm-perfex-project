package pages.customerpages.proposals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonalProposalPage {

    Actions actions;

    public PersonalProposalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    @FindBy(xpath = "//strong")
    private List<WebElement> items;

    @FindBy(id = "accept_action")
    private WebElement accept;

    @FindBy(css = "div.modal-footer>button[type='submit']")
    private WebElement sign;

    @FindBy(css = "p#signatureInput-error")
    private WebElement signatureError;

    @FindBy(css = "p#signatureInput-error")
    private WebElement canvas;

    @FindBy(css = "span.label.label-success.tw-ml-4")
    private WebElement status;

    public void verifyItems(String item1, String item2) {
        Assert.assertEquals(BrowserUtils.getText(items.get(0)), item1);
        Assert.assertEquals(BrowserUtils.getText(items.get(1)), item2);
    }

    public void clickAccept() {
        accept.click();
    }

    public void clickSign() {
        sign.click();
    }

    public String getSingErrorMsg() {
        return BrowserUtils.getText(signatureError);
    }

    public void drawSign() {
        actions.moveToElement(canvas).clickAndHold()
                .moveByOffset(50, 0)
                .moveByOffset(0, 50)
                .release().perform();
    }

    public String getStatus() {
        return BrowserUtils.getText(this.status);
    }
}
