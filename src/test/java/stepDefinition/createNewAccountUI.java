package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import pages.createNewAccount;
import pages.loginPage;
import utils.TestDataReader;
import utils.configReader;
import factory.Driverfactory;
import payload.LoginRequest;

public class createNewAccountUI {

    private Response response;
    private LoginRequest loginRequest;
    private loginPage loginPage;
    private createNewAccount createNewAccount;




    public createNewAccountUI() {
        loginPage = new loginPage(Driverfactory.getDriver());
        createNewAccount = new createNewAccount(Driverfactory.getDriver());
    }




    private String newAccountNumber;

    @Given("the customer is authenticated into Parabank application")
    public void the_customer_is_authenticated_into_parabank_application() {
        Driverfactory.getDriver().get(configReader.getProperty("url"));


        loginRequest = TestDataReader.getLoginData("validUser");
        loginPage.enterUserName(loginRequest.getUsername());
        loginPage.enterPassword   (loginRequest.getPassword());
        loginPage.clickLoginButton();
    }



    @When("the customer requests a new checking account using an existing account")
    public void the_customer_requests_a_new_checking_account_using_an_existing_account() {

        newAccountNumber = createNewAccount.openNewAccount(
                configReader.getProperty("checkingAccountType"),
                configReader.getProperty("existingAccountNumberChecking"));
    }

    @When("the customer requests a new savings account using an existing account")
    public void the_customer_requests_a_new_savings_account_using_an_existing_account() {
        newAccountNumber = createNewAccount.openNewAccount(
                configReader.getProperty("savingsAccountType"),
                configReader.getProperty("existingAccountNumberSavings"));
    }

    @Then("the new account should be created successfully")
    public void the_new_account_should_be_created_successfully() {
        Assert.assertTrue(createNewAccount.isAccountCreated(), "Account was not created successfully.");
    }

    @Then("the customer should be provided with the new account number")
    public void the_customer_should_be_provided_with_the_new_account_number() {
        Assert.assertNotNull(newAccountNumber);
        Assert.assertFalse(newAccountNumber.isEmpty());
        System.out.println("New Account Number : " + newAccountNumber);
    }

    @Then("Verify the account number in Account overview section")
    public void Verify_the_account_number_in_Account_overview_section() {
       createNewAccount.clickAccountOverView();
        Assert.assertTrue(createNewAccount.isAccountPresent(newAccountNumber), "New account number is not displayed");
        createNewAccount.clickAccountIfPresent(newAccountNumber);
    }
}