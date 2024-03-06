package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.employeepages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginSteps {

    private WebDriver driver = DriverHelper.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("Navigate to CRM url")
    public void navigate_to_crm_url() {
        driver.get(ConfigReader.readProperty("url"));
    }

    @Given("Verify the title is {string}")
    public void verify_the_title_is(String title) {
        Assert.assertEquals(driver.getTitle().trim(), title);
    }

    @Given("Verify Log In is visible on the page")
    public void verify_log_in_is_visible_on_the_page() {
        Assert.assertTrue(loginPage.isLoginDisplayed());
    }

    @When("User enters correct employee email and password")
    public void user_enters_correct_employee_email_and_password_and_clicks_login_button() {
        loginPage.login(ConfigReader.readProperty("employee_username"),
                ConfigReader.readProperty("employee_password"));
    }

    @Then("User verifies title is {string}")
    public void user_verifies_title_is(String title) {
        Assert.assertTrue(driver.getTitle().trim().contains(title));
    }

    @When("User enters incorrect employee email and password")
    public void user_enters_incorrect_employee_email_and_password_and_password_and_clicks_login_button() {
        loginPage.login(ConfigReader.readProperty("incorrect_username"),
                ConfigReader.readProperty("employee_password"));
    }

    @Then("User verifies error message {string} in red color")
    public void user_verifies_error_message_in_red_color(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.getErrorMessage());
    }
}
