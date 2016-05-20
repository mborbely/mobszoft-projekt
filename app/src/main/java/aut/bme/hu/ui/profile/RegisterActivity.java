package aut.bme.hu.ui.profile;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;

import java.util.Calendar;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.mobszoft_projekt.R;
import aut.bme.hu.ui.friends.FriendsActivity;
import io.swagger.client.model.Registration;

public class RegisterActivity extends AppCompatActivity implements RegisterScreen {


    private int mYear;
    private int mMonth;
    private int mDay;

    private TextView mDateDisplay;
    private Button mPickDate;

    static final int DATE_DIALOG_ID = 0;

    @Inject
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        SocialApplication.injector.inject(this);
        registerPresenter.attachScreen(this);
        setupDatePicker();

        final Button registerBtn = (Button) findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SocialApplication)getApplication()).getDefaultTracker().send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Registered")
                        .build());

                EditText email = (EditText) findViewById(R.id.email);
                EditText pw = (EditText) findViewById(R.id.password);
                EditText name = (EditText) findViewById(R.id.name);
                EditText birthplace = (EditText) findViewById(R.id.birthplace);


                EditText description = (EditText) findViewById(R.id.description);

                Calendar cal = Calendar.getInstance();
                cal.set(mYear, mMonth, mDay);

                Registration registration = new Registration();
                registration.setEmail( email.getText().toString());
                registration.setPassword(pw.getText().toString());
                registration.setBirthplace(birthplace.getText().toString());
                registration.setDescription(description.getText().toString());
                registration.setName(name.getText().toString());
                registerPresenter.register(registration);
            }
        });

    }

    private void setupDatePicker() {
        mDateDisplay = (TextView) findViewById(R.id.showMyDate);
        mPickDate = (Button) findViewById(R.id.myDatePickerButton);

        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date
        updateDisplay();
    }

    private void updateDisplay() {
        this.mDateDisplay.setText(

                new StringBuilder().append(mYear).append(".")
                        .append(mMonth + 1).append(".")
                        .append(mDay).append("."));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };


    @Override
    protected void onResume() {
        super.onResume();
        ((SocialApplication)getApplication()).getDefaultTracker().setScreenName("Register");
        ((SocialApplication)getApplication()).getDefaultTracker().send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerPresenter.detachScreen();
    }

    @Override
    public void onProfileDataSaved() {
        Intent friendsActtivity = new Intent(this, FriendsActivity.class);
        startActivity(friendsActtivity);
    }
}
