package aut.bme.hu.ui.frienddetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.mobszoft_projekt.R;
import aut.bme.hu.model.User;

public class FriendDetailsActivity extends AppCompatActivity implements FriendDetailsScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SocialApplication.injector.inject(this);
        setContentView(R.layout.activity_friends);

    }

    @Override
    public void navigateBack() {

    }

    @Override
    public void displayFriend(User friend) {

    }
}
