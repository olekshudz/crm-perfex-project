package pages.proposals;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

public class NewProposalPage {

    private DecimalFormat decimalFormat;

    public NewProposalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "subject")
    private WebElement subject;

    @FindBy(css = "select#rel_type")
    private WebElement relatedDropdown;

    @FindBy(id = "rel_id_select")
    private WebElement customer;

    @FindBy(css = "#rel_id_select>div>div>div.bs-searchbox>input")
    private WebElement customerSearchBox;

    @FindBy(xpath = "//div[@id='bs-select-13']//ul//span[@class='text']")
    private List<WebElement> customerList;

    @FindBy(xpath = "//button[@data-id='project_id']")
    private WebElement project;

    @FindBy(css = "#project_ajax_search_wrapper>div>div>div.bs-searchbox>input")
    private WebElement projectSearchBox;

    @FindBy(xpath = "//*[@id='bs-select-16']/ul//span[@class='text']")
    private List<WebElement> projectList;

    @FindBy(id = "item_select")
    private WebElement addItemDropdown;

    @FindBy(css = "i.fa.fa-check")
    private WebElement checkButton;

    @FindBy(xpath = "//*[@id=\"proposal-form\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/input[1]")
    private WebElement cableQuantity;

    @FindBy(css = "td.total")
    private WebElement total;

    @FindBy(xpath = "//button[contains(text(), 'Save & Send')]")
    private WebElement saveAndSend;

    public void fillSubject(String subjectName) {
        this.subject.click();
        this.subject.sendKeys(subjectName);
    }

    public void selectRelated(String relatedName) {
        BrowserUtils.selectBy(relatedDropdown, relatedName, "text");
    }

    public void selectCustomer(String userInput, String customerName) {
        this.customer.click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        this.customerSearchBox.sendKeys(userInput);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        for (int i = 0; i < customerList.size() - 1; i++) {
            if (customerList.get(i).getText().equals(customerName)) {
                customerList.get(i).click();
                break;
            }
        }
    }

    public void selectProject(String userInput, String projectName) {
        this.project.click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        this.projectSearchBox.sendKeys(userInput);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        for (int i = 0; i < projectList.size() - 1; i++) {
            if (projectList.get(i).getText().equals(projectName)) {
                projectList.get(i).click();
                break;
            }
        }
    }

    public void selectItem(String item) {
        BrowserUtils.selectBy(addItemDropdown, item, "text");
    }

    public void clickCheckButton() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        checkButton.click();
    }

    public void changeCableQuantity(String quantity) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        cableQuantity.clear();
        cableQuantity.sendKeys(quantity);
    }

    public String getTotal() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        String total = BrowserUtils.getText(this.total);
        return total;
    }

    public void clickSaveAndSend() {
        saveAndSend.click();
    }
}
