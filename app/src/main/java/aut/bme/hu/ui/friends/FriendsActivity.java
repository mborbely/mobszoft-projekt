package aut.bme.hu.ui.friends;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.common.collect.Lists;

import java.util.List;

import aut.bme.hu.mobszoft_projekt.R;
import aut.bme.hu.model.User;
import aut.bme.hu.ui.friends.list.FriendListFragment;

public class FriendsActivity extends AppCompatActivity implements FriendsScreen, FriendListFragment.UserProvider{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

    }

    @Override
    public void onFriendsArrived(List<User> friends) {

    }

    @Override
    public void userClicked(User user) {

    }

    @Override
    public List<User> getFriends() {
        return Lists.newArrayList(new User("asd", null, null, null), new User("asdasddas", null, null, null));
    }
}
