package login.example.elanic.loginapplication.presenter;

import javax.inject.Inject;

import login.example.elanic.loginapplication.LoginCallback;
import login.example.elanic.loginapplication.model.LoginProvider;
import login.example.elanic.loginapplication.model.LoginResponse;
import login.example.elanic.loginapplication.model.MockLoginProvider;
import login.example.elanic.loginapplication.view.LoginView;

/**
 * Created by ramya on 15/5/17.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView loginView;
    private LoginProvider loginProvider;

    public LoginPresenterImpl(LoginView loginView,LoginProvider loginProvider) {
        this.loginView = loginView;
        this.loginProvider=loginProvider;

    }

    @Override
    public void login(final String username, String password) {
        loginView.showProgress(true);
        if (username.length() == 0) {
            loginView.showError("username should not be empty");
            loginView.showProgress(false);
        }
        if (username.length() < 5) {
            loginView.showError("please enter a valid name (at least 7 characters)");
            loginView.showProgress(false);
        }
        if (password.length() == 0) {
            loginView.showError("password cannot be empty!!");
            loginView.showProgress(false);
        }
        if (password.length() < 5) {
            loginView.showError("please enter a valid password(at least 7 characters)");
            loginView.showProgress(false);
        } else {
            loginProvider.request_login(username, password, new LoginCallback() {
                @Override
                public void onSuccess(boolean success, String message) {
                    if (success) {
                        loginView.showProgress(false);
                        loginView.loginStatus(true);
                    } else {
                        loginView.showError(message);
                        loginView.loginStatus(false);
                    }
                }

                @Override
                public void onFailure() {
                    loginView.loginStatus(false);
                    loginView.showProgress(false);
                    loginView.showError("Please Try again !!");
                }
            });

        }
    }
}
