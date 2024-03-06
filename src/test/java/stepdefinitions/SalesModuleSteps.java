package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.employeepages.MainPage;
import pages.employeepages.proposals.ProposalsPage;
import utils.DriverHelper;

import java.util.List;

public class SalesModuleSteps {

    private WebDriver driver = DriverHelper.getDriver();
    private MainPage mainPage = new MainPage(driver);
    private ProposalsPage proposalsPage = new ProposalsPage(driver);

    @When("Click {string} Module from left side navigation menu")
    public void click_module_from_left_side_navigation_menu(String moduleName) {
        mainPage.selectLeftSideModule(moduleName);
    }

    @Then("Verify that there are {int} sub module under Sales module")
    public void verify_that_there_are_sub_module_under_sales_module(int subModulesNumber) {
        Assert.assertEquals(subModulesNumber, mainPage.getSalesSubModuleNumber());
    }

    @Then("Verify that order of sub modules are:")
    public void verify_that_order_of_sub_modules_are(DataTable dataTable) {
        List<String> expectedOrder = dataTable.asList(String.class);
        Assert.assertTrue("Order of sub-modules is incorrect",
                mainPage.verifyOrderOfSalesSubModule(expectedOrder));
    }

    @Then("User clicks {string} module")
    public void user_clicks_module(String subModuleName) {
        mainPage.selectSalesModule(subModuleName);
    }

    @Then("User verifies that there is button New Proposal and it's background-color is {string}")
    public void user_verifies_that_there_is_button_and_it_s_background_color_is(String color) {
        Assert.assertTrue(proposalsPage.isNewProposalButtonDisplayed());
        Assert.assertEquals(color, proposalsPage.getNewProposalButtonColor());
    }
}
