package tests.api;

import org.testng.annotations.Test;
import services.AuthService;

public class AuthTest {

   // @Test
    public void testLogin() {

        AuthService authService = new AuthService();

        String token = authService.getToken();

        System.out.println("Token: " + token);

        assert token != null;
    }
}