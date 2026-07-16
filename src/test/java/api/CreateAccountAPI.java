package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.CreateAccountRequest;

public class CreateAccountAPI {

    ApiHelper apiHelper = new ApiHelper();
    public Response createAccount(CreateAccountRequest requestData) {
            RequestSpecification request = apiHelper.getRequest()
                .queryParam("customerId",
                                requestData.getCustomerId())
                .queryParam("newAccountType",
                                requestData.getAccountType())
                .queryParam("fromAccountId",
                                requestData.getFromAccountId());
        return apiHelper.post("/createAccount", request);
    }


}