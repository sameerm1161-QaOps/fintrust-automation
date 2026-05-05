package stepdefinitions;

import core.ScenarioContext;
import core.TestContext;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import models.BookingDates;
import models.BookingRequest;
import services.BookingService;

public class BookingSteps {

    BookingService bookingService = new BookingService();

    @Given("user creates a booking")
    public void createBooking() {

        // 🔥 CHANGE: Using POJO instead of raw JSON
        BookingDates dates = new BookingDates("2024-01-01", "2024-01-05");

        BookingRequest request = new BookingRequest(
                "John",
                "Doe",
                100,
                true,
                dates
        );

        Response response = bookingService.createBooking(request);

        int bookingId = response.jsonPath().getInt("bookingid");
        TestContext.setBookingId(bookingId);

        ScenarioContext.set("createResponse", response);

        Allure.addAttachment("Create Response", response.asPrettyString());
    }

    @When("user fetches booking by id")
    public void fetchBooking() {

        int id = TestContext.getBookingId();

        Response response = bookingService.getBookingById(id);

        ScenarioContext.set("getResponse", response);

        Allure.addAttachment("Get Response", response.asPrettyString());
    }

    @Then("booking price should be correct")
    public void validateBooking() {

        Response response = (Response) ScenarioContext.get("getResponse");

        int price = response.jsonPath().getInt("totalprice");

        if (price != 100) {
            throw new RuntimeException("Price mismatch!");
        }
    }
}