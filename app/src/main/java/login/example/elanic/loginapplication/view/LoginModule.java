package login.example.elanic.loginapplication.view;

import dagger.Module;
import dagger.Provides;
import login.example.elanic.loginapplication.model.LoginProvider;
import login.example.elanic.loginapplication.model.LoginProviderImpl;
import login.example.elanic.loginapplication.model.MockLoginProvider;
import login.example.elanic.loginapplication.presenter.LoginPresenter;
import login.example.elanic.loginapplication.presenter.LoginPresenterImpl;

/**
 * Created by ramya on 15/5/17.
 */

@Module
public class LoginModule {
    private LoginView loginView;

    public LoginModule(LoginView view) {
        this.loginView = view;
    }

    @Provides
    LoginPresenter provideLoginPresenter(LoginProvider loginProvider) {

        return new LoginPresenterImpl(loginView,loginProvider);
    }
    @Provides
    LoginProvider provideLoginInteractor() {
        return new MockLoginProvider();
    }



}
