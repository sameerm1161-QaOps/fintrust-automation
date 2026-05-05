package tests.e2e;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import services.TransactionService;

public class BookingE2ETest {

    @Test
    @Description("Verify booking end to end flow")
    @Severity(SeverityLevel.CRITICAL)
    public void testBookingFlow() {

        TransactionService service = new TransactionService();

        // 🔥 CHANGE: Updated method name
        service.completeBookingFlow(); // ✅ FIX
    }
}