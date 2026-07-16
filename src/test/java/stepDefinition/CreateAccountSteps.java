package stepDefinition;

import api.CreateAccountAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import payload.CreateAccountRequest;
import utils.ResponseValidator;
import utils.TestDataReader;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class CreateAccountSteps {

    private Response response;
    private CreateAccountRequest request;
    private final CreateAccountAPI createAccountAPI = new CreateAccountAPI();

    @Given("the Create Account service is available")
    public void the_create_account_service_is_available() {

        // API Helper handles base URI, headers and authentication.
        // Nothing to do here.
    }

    @When("the customer submits a valid account creation request")
    public void the_customer_submits_a_valid_account_creation_request() {
        // Read test data
        request = TestDataReader.getCreateAccountData("validAccount");
        // Call API
        response = createAccountAPI.createAccount(request);
    }

    @Then("the account should be created successfully")
    public void the_account_should_be_created_successfully() {
        ResponseValidator.verifyStatusCode(response, 200);
    }

    @Then("the response should contain the new account details")
    public void the_response_should_contain_the_new_account_details() {
        ResponseValidator.verifySchema(response, "schemas/createAccountSchema.json");

    }

    @When("the customer submits an account creation request with an invalid customer")
    public void invalid_customer_request() {
        request = TestDataReader.getCreateAccountData("invalidCustomer");
        response = createAccountAPI.createAccount(request);
    }

    @When("the customer submits an incomplete account creation request")
    public void blank_request() {
        request = TestDataReader.getCreateAccountData("blankRequest");
        response = createAccountAPI.createAccount(request);
    }

    @Then("the request should be rejected")
    public void request_should_be_rejected() {
        ResponseValidator.verifyStatusCode(response, 400);
    }


    @Then("an appropriate error message should be returned")
    public void verify_error_message() {
        ResponseValidator.verifyResponseContains(response, "Could not create new account");
    }

    @Then("validation errors should be returned")
    public void validation_errors_should_be_returned() {
        ResponseValidator.verifyResponseContains(response, "Could not create new account");

    }
}