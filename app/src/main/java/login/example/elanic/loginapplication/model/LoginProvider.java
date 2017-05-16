package login.example.elanic.loginapplication.model;

import login.example.elanic.loginapplication.LoginCallback;

/**
 * Created by ramya on 15/5/17.
 */

public interface LoginProvider {
    void request_login(String username, String password, LoginCallback loginCallback);
}
