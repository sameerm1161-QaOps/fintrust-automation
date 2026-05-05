package services;

import org.checkerframework.checker.units.qual.A;

public class UserService {
    private AuthService authService;

    public UserService(){
        authService=new AuthService();
    }
    public String loginAndGetToken(String username, String password){
        return authService.getToken();
    }
}
