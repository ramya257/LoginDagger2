package login.example.elanic.loginapplication.view;

/**
 * Created by ramya on 15/5/17.
 */

public interface LoginView {
    void showError(String message);
    void showProgress(boolean show);
    void loginStatus(boolean login);
}
