package tests.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class testDirectApi {

    //@Test
    public void testDirectApi() {

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()
                .statusCode(200);
    }
}