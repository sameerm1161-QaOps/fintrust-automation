package core;

public class TestContext {

    private static ThreadLocal<Integer> bookingId = new ThreadLocal<>();

    public static void setBookingId(int id) {
        bookingId.set(id);
    }

    public static int getBookingId() {
        Integer id = bookingId.get();

        if (id == null) {
            throw new RuntimeException("Booking ID not set for this scenario");
        }

        return id;
    }

    public static void clear() {
        bookingId.remove();
    }
}