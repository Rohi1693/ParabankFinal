package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.configReader;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    public ApiHelper() {
        RestAssured.baseURI = configReader.getProperty("apiBaseUrl");;
    }

    public Response post(String endpoint,
                         RequestSpecification request) {
        return request.post(endpoint);
    }

    public RequestSpecification getRequest() {
        return given()
                .contentType("application/json")
                .accept("application/json");
    }

    public Response get(String endpoint) {

return getRequest().get(endpoint);
    }
}