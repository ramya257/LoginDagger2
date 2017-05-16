package login.example.elanic.loginapplication;

import login.example.elanic.loginapplication.model.LoginResponse;

/**
 * Created by ramya on 15/5/17.
 */

public interface LoginCallback {
    void onSuccess(boolean success,String message);
    void onFailure();
}
