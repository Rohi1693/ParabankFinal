package utils;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;

public class ResponseValidator {

    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        response.then()
                .statusCode(expectedStatusCode);
    }

    public static void verifySchema(Response response, String schemaPath) {
        response.then()
                .body(matchesJsonSchemaInClasspath(schemaPath));
    }

    public static void verifyResponseContains(Response response, String expectedMessage) {
        response.then()
                .body(containsString(expectedMessage));
    }


}