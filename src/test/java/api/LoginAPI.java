package api;

import io.restassured.response.Response;
import payload.LoginRequest;

public class LoginAPI {

    ApiHelper apiHelper = new ApiHelper();

    public Response login(LoginRequest request) {

        return apiHelper.get("/login/"
                        + request.getUsername() + "/" + request.getPassword());
    }

}