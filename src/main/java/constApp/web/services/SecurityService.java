package constApp.web.services;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}