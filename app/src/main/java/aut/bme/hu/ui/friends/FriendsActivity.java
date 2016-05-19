package aut.bme.hu.ui.friends;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.common.collect.Lists;

import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.mobszoft_projekt.R;
import aut.bme.hu.model.User;
import aut.bme.hu.ui.friends.list.FriendListFragment;
import aut.bme.hu.ui.friends.list.UserRow;

public class FriendsActivity extends AppCompatActivity implements FriendsScreen, FriendListFragment.UserProvider{

    @Inject
    FriendsPresenter friendsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        SocialApplication.injector.inject(this);
        friendsPresenter.attachScreen(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        friendsPresenter.detachScreen();
    }

    @Override
    public void onFriendsArrived(List<User> friends) {

    }

    @Override
    public void addFriendClicked(UserRow user) {
        friendsPresenter.userClicked(user);
    }

    @Override
    public void showDetails(UserRow friend) {

    }

    @Override
    public void updateList() {
        FriendListFragment friendListFragment = (FriendListFragment) getFragmentManager().findFragmentByTag("listfriendsfrag");
        friendListFragment.update();
    }

    @Override
    public List<UserRow> getFriends() {
        return Lists.newArrayList(new UserRow(new User("asd", null, null, null), false), new UserRow(new User("asdasddas", null, null, null), true));
    }

    @Override
    public void addFriendSuccess() {
        Toast.makeText(this,  "Successfully added friend.", Toast.LENGTH_SHORT).show();
    }
}
