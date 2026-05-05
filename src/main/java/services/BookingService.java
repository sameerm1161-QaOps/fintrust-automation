package services;

import core.api.BaseApi;
import io.restassured.response.Response;
import models.BookingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import core.utils.ConfigReader;

public class BookingService extends BaseApi {

    private static final Logger log = LoggerFactory.getLogger(BookingService.class);

    // 🔥 CHANGE: Now accepts POJO instead of String
    public Response createBooking(BookingRequest request) {

        log.info("Creating booking with POJO...");

        String baseUrl = ConfigReader.get("baseUrl");

        return givenRequest()
                .baseUri(baseUrl)
                .body(request) // 🔥 Jackson auto converts to JSON
                .post("/booking");
    }

    public Response getBookingById(int bookingId) {

        log.info("Fetching booking ID: {}", bookingId);

        String baseUrl = ConfigReader.get("baseUrl");

        return givenRequest()
                .baseUri(baseUrl)
                .get("/booking/" + bookingId);
    }
}