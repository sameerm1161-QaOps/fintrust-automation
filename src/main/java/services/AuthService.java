package services;

import core.api.BaseApi;
import io.restassured.response.Response;

public class AuthService extends BaseApi {

    public String getToken() {

        String payload = "{ \"username\": \"admin\", \"password\": \"password123\" }";

        Response response = givenRequest()
                .body(payload)
                .post("/auth");

        System.out.println(response.getBody().asString());

        return response.jsonPath().getString("token");
    }
}