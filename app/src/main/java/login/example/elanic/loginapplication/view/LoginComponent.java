package login.example.elanic.loginapplication.view;

import dagger.Component;
import login.example.elanic.loginapplication.dagger.ActivityScope;

/**
 * Created by ramya on 15/5/17.
 */
@ActivityScope
@Component(
        modules = {LoginModule.class}
)
public interface LoginComponent {
    void inject(MainActivity activity);
}
