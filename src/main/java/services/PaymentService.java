package services;

import core.api.BaseApi;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PaymentService extends BaseApi {

    public Response performPayment(String username, String password, String amount) {

        return givenRequest()
                .queryParam("username", username)
                .queryParam("password", password)
                .queryParam("amount", amount)
                .post("/payment");
    }
}