package aut.bme.hu.mobszoft_projekt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.ui.login.LoginPresenter;
import aut.bme.hu.ui.login.LoginScreen;

public class LoginActivity extends AppCompatActivity implements LoginScreen{

    @Inject
    LoginPresenter loginPresenter;

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Successful login", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SocialApplication.injector.inject(this);

        loginPresenter.attachScreen(this);


        View loginBtn = findViewById(R.id.login_btn);
        Button loginButton = (Button) loginBtn;
        final EditText emailField = (EditText)findViewById(R.id.email);
        final EditText passwordField = (EditText)findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                loginPresenter.login(emailField.getText().toString(), passwordField.getText().toString());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
