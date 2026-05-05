package services;

import core.utils.DataGenerator;
import io.restassured.response.Response;
import models.BookingRequest;
import core.utils.TestDataReader;

public class TransactionService {

    BookingService bookingService = new BookingService();

    public void completeBookingFlow() {

        System.out.println("Thread: " + Thread.currentThread().getId());

        // 🔥 CHANGE: Read from JSON instead of hardcode
        BookingRequest request = TestDataReader.getBookingData();
        request.setFirstname(DataGenerator.getRandomName());

        Response createResponse = bookingService.createBooking(request);

        int bookingId = createResponse.jsonPath().getInt("bookingid");

        System.out.println("Created Booking ID: " + bookingId);

        Response getResponse = bookingService.getBookingById(bookingId);

        if (getResponse.getStatusCode() != 200) {
            throw new RuntimeException("Get booking failed!");
        }

        System.out.println("Booking verified successfully");
    }
}