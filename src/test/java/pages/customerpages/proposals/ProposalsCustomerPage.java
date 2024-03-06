package pages.customerpages.proposals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ProposalsCustomerPage {

    public ProposalsCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody>tr>td")
    private List<WebElement> tableData;

    @FindBy(css = "input[type='search']")
    private WebElement searchBox;

    public void searchForProposal(String proposalName) {
        this.searchBox.sendKeys(proposalName);
    }

    public String getSubject() {
        System.out.println("Subject: " + BrowserUtils.getText(tableData.get(1)));
        return BrowserUtils.getText(tableData.get(1));
    }

    public String getTotal() {
        System.out.println("Total: " + BrowserUtils.getText(tableData.get(2)));
        return BrowserUtils.getText(tableData.get(2));
    }

    public void clickProposal() {
        tableData.get(0).click();
    }
}
