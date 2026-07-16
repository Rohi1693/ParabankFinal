package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import payload.CreateAccountRequest;
import payload.LoginRequest;

import java.io.File;
import java.io.IOException;

public class TestDataReader {

    public static CreateAccountRequest getCreateAccountData(String testDataName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("src/test/resources/testdata/createAccount.json");
            com.fasterxml.jackson.databind.JsonNode root = mapper.readTree(file);
            return mapper.treeToValue(root.get(testDataName),
                    CreateAccountRequest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    public static LoginRequest getLoginData(String testDataName) {

        ObjectMapper mapper = new ObjectMapper();
        try {

            File file = new File("src/test/resources/testdata/login.json");
            JsonNode root = mapper.readTree(file);
            return mapper.treeToValue(root.get(testDataName),
                    LoginRequest.class);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }
}