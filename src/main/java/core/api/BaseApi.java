package core.api;

import config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;

import javax.security.auth.login.Configuration;

import static io.restassured.RestAssured.given;

public class BaseApi {
    protected RequestSpecification request;

    public BaseApi(){
        request = new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getInstance().getProperty("baseUrl"))
                .addHeader("Content-Type","application/json")
                .build();
    }

    protected RequestSpecification givenRequest(){
        return given().spec(request);
    }
}
