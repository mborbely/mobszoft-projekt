package aut.bme.hu.ui.frienddetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;

import java.math.BigDecimal;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.mobszoft_projekt.R;
import io.swagger.client.model.PersonDetails;

public class FriendDetailsActivity extends AppCompatActivity implements FriendDetailsScreen {

    @Inject
    FriendDetailsPresenter friendDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_details);
        SocialApplication.injector.inject(this);
        SocialApplication.injector.inject(this);


        friendDetailsPresenter.attachScreen(this);

        Intent intent = getIntent();
        BigDecimal id = new BigDecimal(intent.getStringExtra("id"));

        friendDetailsPresenter.getFriendDetails(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        friendDetailsPresenter.detachScreen();
    }

    @Override
    public void navigateBack() {

    }

    @Override
    public void displayFriend(PersonDetails friend) {
        TextView birthplace= (TextView) findViewById(R.id.birthplace);
        TextView description= (TextView) findViewById(R.id.desc);
        TextView name= (TextView) findViewById(R.id.name);
        TextView email= (TextView) findViewById(R.id.email);

        birthplace.setText(friend.getBirthplace());
        description.setText(friend.getDescription());
        name.setText(friend.getName());
        email.setText(friend.getEmail());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("FriendDetailsActivity", "OnResume");
        ((SocialApplication)getApplication()).getDefaultTracker().setScreenName("FriendDetailsList");
        ((SocialApplication)getApplication()).getDefaultTracker().send(new HitBuilders.ScreenViewBuilder().build());
    }
}
