package pages.employeepages.proposals;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.Duration;

public class ProposalsPage {

    public ProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "New Proposal")
    private WebElement newProposalButton;

    @FindBy(xpath = "//tr[@class='has-row-options odd']/td[10]")
    private WebElement status;

    @FindBy(css = "div.input-group>input")
    private WebElement searchBtn;

    @FindBy(xpath = "//td/a[contains(text(), 'Alex')]")
    private WebElement proposal;

    @FindBy(xpath = "//button[contains(text(), 'More')]")
    private WebElement moreBtn;

    @FindBy(partialLinkText = "Delete")
    private WebElement deleteBtn;

    @FindBy(css = "select[name='DataTables_Table_0_length']")
    private WebElement tableLength;

    public void clickNewProposal() {
        this.newProposalButton.click();
    }

    public String getStatus() {
        return BrowserUtils.getText(status);
    }

    public boolean isNewProposalButtonDisplayed() {
        return newProposalButton.isDisplayed();
    }

    public String getNewProposalButtonColor() {
        return newProposalButton.getCssValue("background-color");
    }

    public void selectTableLength(String length) {
        BrowserUtils.selectBy(this.tableLength, length, "text");
    }

    public void deleteCreatedProposal(WebDriver driver, String proposal) {
        searchBtn.sendKeys(proposal);
        this.proposal.click();
        this.moreBtn.click();
        this.deleteBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.navigate().refresh();
    }
}
