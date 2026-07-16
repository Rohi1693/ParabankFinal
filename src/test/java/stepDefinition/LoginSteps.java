package stepDefinition;

import api.LoginAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import payload.LoginRequest;
import utils.ResponseValidator;
import utils.TestDataReader;

public class LoginSteps {

    private Response response;
    private LoginRequest request;

    LoginAPI loginAPI = new LoginAPI();

    @Given("the Login service is available")
    public void the_login_service_is_available() {

        System.out.println("Login API is ready.");

    }

    @When("the client logs in with valid credentials")
    public void the_client_logs_in_with_valid_credentials() {

        request = TestDataReader.getLoginData("validUser");

        response = loginAPI.login(request);

    }

    @When("the client logs in with an invalid username")
    public void the_client_logs_in_with_an_invalid_username() {

        request = TestDataReader.getLoginData("invalidUsername");

        response = loginAPI.login(request);

    }

    @When("the client logs in with an invalid password")
    public void the_client_logs_in_with_an_invalid_password() {

        request = TestDataReader.getLoginData("invalidPassword");

        response = loginAPI.login(request);

    }

    @When("the client logs in without credentials")
    public void the_client_logs_in_without_credentials() {

        request = TestDataReader.getLoginData("blankCredentials");

        response = loginAPI.login(request);

    }

    @Then("the login should be successful")
    public void the_login_should_be_successful() {

        ResponseValidator.verifyStatusCode(response,200);

    }

    @Then("the customer details should be returned")
    public void the_customer_details_should_be_returned() {

        ResponseValidator.verifyResponseContains(response,"John");

    }

    @Then("the login should be rejected with invalid username")
    public void the_login_should_be_rejected_with_invalid_username() {

        ResponseValidator.verifyStatusCode(response,400);

    }

    @Then("the login should be rejected with invalid password")
    public void the_login_should_be_rejected_with_invalid_password() {

        ResponseValidator.verifyStatusCode(response,400);

    }

    @Then("an appropriate authentication error should be returned")
    public void an_appropriate_authentication_error_should_be_returned() {

        ResponseValidator.verifyResponseContains(response,
                "Invalid username and/or password");

    }

}