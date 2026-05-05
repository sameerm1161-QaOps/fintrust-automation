package core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.BookingRequest;

import java.io.File;
import java.io.IOException;

public class TestDataReader {

    public static BookingRequest getBookingData() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(
                    new File("src/test/resources/testdata/booking.json"),
                    BookingRequest.class
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data", e);
        }
    }
}