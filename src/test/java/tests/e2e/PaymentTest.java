package tests.e2e;

import org.testng.annotations.Test;
import services.TransactionService;

public class PaymentTest {

    @Test
    public void testEndToEndFlow() {

        TransactionService service = new TransactionService();

        service.completeBookingFlow();
    }
}