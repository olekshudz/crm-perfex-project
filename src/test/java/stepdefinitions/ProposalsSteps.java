package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.employeepages.MainPage;
import pages.employeepages.proposals.NewProposalPage;
import pages.employeepages.proposals.ProposalsPage;
import utils.DataTableUtils;
import utils.DriverHelper;

import java.util.Map;

public class ProposalsSteps {

    private WebDriver driver = DriverHelper.getDriver();
    private MainPage mainPage = new MainPage(driver);
    private ProposalsPage proposalsPage = new ProposalsPage(driver);
    private NewProposalPage newProposalPage = new NewProposalPage(driver);

    Map<String, String> rowData;

    @When("Click New Proposal button from top")
    public void click_button_from_top() {
        proposalsPage.clickNewProposal();
    }

    @When("User fills new proposal info with:")
    public void fill_the_subject_line_with(DataTable dataTable) {
        rowData = DataTableUtils.getDataFromTable(dataTable);
        newProposalPage.fillSubject(rowData.get("subject"));
        newProposalPage.selectRelated(rowData.get("related"));
        newProposalPage.selectCustomer(rowData.get("customer"), rowData.get("customerName"));
        newProposalPage.selectProject(rowData.get("project"), rowData.get("projectName"));
    }

    @When("User clicks Add Item button and selects items from drop down list and clicks blue check button:")
    public void user_clicks_add_item_button_and_selects_items_from_drop_down_list_and_clicks_blue_check_button
            (DataTable dataTable) {
        rowData = DataTableUtils.getDataFromTable(dataTable);
        newProposalPage.selectItem(rowData.get("item1"));
        newProposalPage.clickCheckButton();
        newProposalPage.selectItem(rowData.get("item2"));
        newProposalPage.changeCableQuantity(rowData.get("quantity"));
        newProposalPage.clickCheckButton();
    }

    @Then("User verifies that Total is {string} and clicks Save & Send button")
    public void user_verifies_that_total_is_and_clicks_save_send_button(String total) {
        Assert.assertEquals(total, newProposalPage.getTotal());
        newProposalPage.clickSaveAndSend();
    }

    @Then("User finds created Proposal by clicking {string}, {string} and verify that its status is {string}")
    public void user_finds_created_proposal_by_clicking_and_verify_that_its_status_is
            (String leftModule, String salesModule, String status) {
        mainPage.selectLeftSideModule(leftModule);
        mainPage.selectSalesModule(salesModule);
        Assert.assertEquals(status, proposalsPage.getStatus());
    }

    @Then("User deletes the created proposal {string}")
    public void user_deletes_the_created_proposal(String proposal) {
        proposalsPage.deleteCreatedProposal(driver, proposal);
    }

    @When("User sets table length {string} from drop down menu that is next to Export button on top of table")
    public void user_sets_table_length_from_drop_down_menu_that_is_next_to_export_button_on_top_of_table(String length) {
        proposalsPage.selectTableLength(length);
    }

    @Then("From table verify that approved proposal status label is {string}")
    public void from_table_verify_that_approved_proposal_status_label_is(String status) {
        Assert.assertEquals(status, proposalsPage.getStatus());
    }
}
