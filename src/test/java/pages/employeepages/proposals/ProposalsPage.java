package pages.employeepages.proposals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ProposalsPage {

    public ProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "New Proposal")
    private WebElement newProposalButton;

    @FindBy(xpath = "//span[contains(text(), 'Sent')]")
    private WebElement status;

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
}
