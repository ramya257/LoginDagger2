package login.example.elanic.loginapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import login.example.elanic.loginapplication.R;
import login.example.elanic.loginapplication.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginView {
    private Button login_button;
    private EditText username_edit_text;
    private EditText password_edit_text;
    private ProgressBar progressBar;
    @Inject LoginPresenter loginPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_button=(Button)findViewById(R.id.login);
        username_edit_text=(EditText)findViewById(R.id.name_edit_text);
        password_edit_text=(EditText)findViewById(R.id.password_edit_text);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
        /*loginPresenter=new LoginPresenterImpl(this,new MockLoginProvider());*/
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=username_edit_text.getText().toString();
                String password=password_edit_text.getText().toString();
           loginPresenter.login(username,password);
            }
        });

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress(boolean show) {
        if(show)
        {
           progressBar.setVisibility(View.VISIBLE);
        }
        else {
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void loginStatus(boolean login) {
        if (login)
        {
            Intent intent=new Intent(this,WelcomeActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
