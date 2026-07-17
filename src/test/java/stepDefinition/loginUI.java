package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.loginPage;
import payload.LoginRequest;
import utils.TestDataReader;
import utils.configReader;
import factory.Driverfactory;

public class loginUI {

    private loginPage loginPage;
    private LoginRequest loginRequest;

    @Given("the ParaBank application is available")
    public void the_para_bank_application_is_available() {
        Driverfactory.getDriver().get(configReader.getProperty("url"));
        loginPage = new loginPage(Driverfactory.getDriver());
    }

    @When("the customer signs in with valid credentials")
    public void the_customer_signs_in_with_valid_credentials() {
        loginRequest = TestDataReader.getLoginData("validUser");
        loginPage.enterUserName(loginRequest.getUsername());
        loginPage.enterPassword   (loginRequest.getPassword());
    }

    @Then("the customer should be successfully authenticated")
    public void the_customer_should_be_successfully_authenticated() {
        loginPage.clickLoginButton();
    }

    @Then("the customer should be taken to the account overview page")
    public void the_customer_should_be_taken_to_the_account_overview_page() {
        Assert.assertEquals(loginPage.getPageTitle(), "ParaBank | Accounts Overview");
    }
}