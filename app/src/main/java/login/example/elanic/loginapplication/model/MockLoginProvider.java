package login.example.elanic.loginapplication.model;

import login.example.elanic.loginapplication.LoginCallback;
import login.example.elanic.loginapplication.presenter.LoginPresenter;

/**
 * Created by ramya on 15/5/17.
 */

public class MockLoginProvider implements LoginProvider {
    private String name="Ramya";
    private String password="asdfg45";
    private LoginPresenter loginPresenter;
    public MockLoginProvider()
    {}


    @Override
    public void request_login(String username, String password, LoginCallback loginCallback) {
            if(username.equals(name)&&password.equals(password)){
              loginCallback.onSuccess(true,"success");
            }
            else {
                loginCallback.onFailure();
            }
    }
}
