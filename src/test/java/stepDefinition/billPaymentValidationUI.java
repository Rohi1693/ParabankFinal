package stepDefinition;

import factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import pages.createNewAccount;
import pages.loginPage;
import pages.billPaymentPage;

import payload.LoginRequest;
import utils.TestDataReader;
import utils.configReader;


public class billPaymentValidationUI {

    private Response response;
    private LoginRequest loginRequest;
    private loginPage loginPage;
    private createNewAccount createNewAccount;
    private billPaymentPage billPaymentPage;

    public billPaymentValidationUI() {
        loginPage = new loginPage(Driverfactory.getDriver());
        createNewAccount = new createNewAccount(Driverfactory.getDriver());
        billPaymentPage = new billPaymentPage(Driverfactory.getDriver());

    }


    @Given("the customer is authenticated into application")
    public void the_customer_is_authenticated_into_parabank_application() {
        Driverfactory.getDriver().get(configReader.getProperty("url"));
        loginRequest = TestDataReader.getLoginData("validUser");
        loginPage.enterUserName(loginRequest.getUsername());
        loginPage.enterPassword   (loginRequest.getPassword());
        loginPage.clickLoginButton();
    }

    @Given("the customer land on a bill payment page")
    public void the_customer_land_on_a_bill_payment_page() {
        billPaymentPage.clickBillPayLink();

    }
    @When("the customer submits a bill payment with all required payment details")
    public void the_customer_submits_a_bill_payment_with_all_required_payment_details() {
        billPaymentPage.enterBillPaymentDetails(
                configReader.getProperty("payeeName"),
                configReader.getProperty("payeeAddress"),
                configReader.getProperty("payeeCity"),
                configReader.getProperty("payeeZipCode"),
                configReader.getProperty("payeeAccountNumber"),
                configReader.getProperty("billAmount"), configReader.getProperty("phone"),
        configReader.getProperty("state"));

    }
    @Then("the bill payment should be processed successfully")
    public void the_bill_payment_should_be_processed_successfully() {
        billPaymentPage.clickSendPaymentButton();
        billPaymentPage.isPaymentCompleted();

    }
    @Then("the payment should be associated with the selected payee")
    public void the_payment_should_be_associated_with_the_selected_payee() {
        Assert.assertEquals(configReader.getProperty("payeeName"), billPaymentPage.getPayeeName());
    }

    @Given("the payee contact information is incomplete")
    public void the_payee_contact_information_is_incomplete() {
        billPaymentPage.enterSomeBillPaymentDetails(
                configReader.getProperty("payeeName"),
                configReader.getProperty("payeeAddress"),
                configReader.getProperty("payeeCity"),
                configReader.getProperty("payeeZipCode"),
                configReader.getProperty("payeeAccountNumber"),
                configReader.getProperty("billAmount"));

    }

    @When("the customer submits the payment request")
    public void the_customer_submits_the_payment_request() {
        billPaymentPage.clickSendPaymentButton();

    }

    @Then("the payment should not be processed")
    public void the_payment_should_not_be_processed() {
        Assert.assertFalse( billPaymentPage.isPaymentCompleted(),"Payment is completed");

    }



}

