package aut.bme.hu.mobszoft_projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.HitBuilders;

import io.fabric.sdk.android.Fabric;
import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.ui.friends.FriendsActivity;
import aut.bme.hu.ui.login.LoginPresenter;
import aut.bme.hu.ui.login.LoginScreen;
import aut.bme.hu.ui.profile.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginScreen{

    @Inject
    LoginPresenter loginPresenter;

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        SocialApplication.injector.inject(this);

        loginPresenter.attachScreen(this);

        setupRegisterButton();

        setupLoginButton();

    }

    private void setupRegisterButton() {
        View loginBtn = findViewById(R.id.login_btn);
        Button loginButton = (Button) loginBtn;
        final EditText emailField = (EditText)findViewById(R.id.email);
        final EditText passwordField = (EditText)findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((SocialApplication)getApplication()).getDefaultTracker().send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Logged in")
                        .build());
                loginPresenter.login(emailField.getText().toString(), passwordField.getText().toString());
            }
        });
    }

    private void setupLoginButton() {
        View btn = findViewById(R.id.register_btn);
        Button registerButton = (Button) btn;
        final EditText emailField = (EditText)findViewById(R.id.email);
        final EditText passwordField = (EditText)findViewById(R.id.password);

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
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

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LoginActvity", "OnResume");
        ((SocialApplication)getApplication()).getDefaultTracker().setScreenName("Login");
        ((SocialApplication)getApplication()).getDefaultTracker().send(new HitBuilders.ScreenViewBuilder().build());
    }
}
