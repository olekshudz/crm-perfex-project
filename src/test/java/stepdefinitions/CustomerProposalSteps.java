package stepdefinitions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.customerpages.LoginCustomerPage;
import pages.customerpages.MainCustomerPage;
import pages.customerpages.proposals.PersonalProposalPage;
import pages.customerpages.proposals.ProposalsCustomerPage;
import utils.ConfigReader;
import utils.DataTableUtils;
import utils.DriverHelper;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CustomerProposalSteps {

    private WebDriver driver = DriverHelper.getDriver();
    private LoginCustomerPage loginCustomerPage = new LoginCustomerPage(driver);
    private MainCustomerPage mainCustomerPage = new MainCustomerPage(driver);
    private ProposalsCustomerPage proposalsCustomerPage = new ProposalsCustomerPage(driver);
    private PersonalProposalPage personalProposalPage = new PersonalProposalPage(driver);

    Map<String, String> rowData;

    @Given("User navigates to customer url")
    public void user_navigates_to_customer_url() {
        driver.get(ConfigReader.readProperty("customer_url"));
    }

    @Given("User enters correct customer credentials")
    public void user_enters_correct_customer_credentials() {
        loginCustomerPage.login(ConfigReader.readProperty("customer_username"),
                ConfigReader.readProperty("customer_password"));
    }

    @When("User verifies that page title is {string}")
    public void user_verifies_that_page_title_is(String title) {
        Assert.assertEquals(title, driver.getTitle().trim());
    }

    @When("User clicks {string} from top navigation menu")
    public void user_clicks_from_top_navigation_menu(String module) {
        mainCustomerPage.selectTopBarModule(module);
    }

    @When("User searches for proposal {string} and verifies following info:")
    public void user_searches_for_proposal_and_verifies_following_info(String proposal, DataTable data) {
        proposalsCustomerPage.searchForProposal(proposal);
        rowData = DataTableUtils.getDataFromTable(data);
        Assert.assertEquals(rowData.get("subject"), proposalsCustomerPage.getSubject());
        Assert.assertEquals(rowData.get("total"), proposalsCustomerPage.getTotal());
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    @When("User clicks proposal")
    public void user_clicks_proposal() {
        proposalsCustomerPage.clickProposal();
    }

    @Then("User verifies that title is {string}")
    public void user_verifies_that_title_is(String title) {
        Assert.assertEquals(title, driver.getTitle().trim());
    }

    @Then("User verifies info and clicks Accept button after:")
    public void user_verifies_info_and_clicks_accept_button_after(DataTable data) {
        Map<String, String> rows = DataTableUtils.getDataFromTable(data);
        personalProposalPage.verifyItems(rows.get("item1"), rows.get("item2"));
        personalProposalPage.clickAccept();
    }

    @Then("From pop up, click Sign and verify user gets red error message that {string}")
    public void from_pop_up_click_sign_and_verify_user_gets_red_error_message_that(String errorMessage) {
        personalProposalPage.clickSign();
        Assert.assertEquals(errorMessage, personalProposalPage.getSingErrorMsg());
    }

    @Then("User draws a signature in canvas, clicks Sign")
    public void user_draws_a_signature_in_canvas_clicks_sign() {
        personalProposalPage.drawSign();
        personalProposalPage.clickSign();
    }

    @Then("User verifies {string} status label with green background next to proposal id")
    public void user_verifies_status_label_with_green_background_next_to_proposal_id(String status) {
        Assert.assertEquals(status, personalProposalPage.getStatus());
    }
}
