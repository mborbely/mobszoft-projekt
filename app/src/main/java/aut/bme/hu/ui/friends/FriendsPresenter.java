package aut.bme.hu.ui.friends;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.interactor.friends.FriendsDownloadedEvent;
import aut.bme.hu.interactor.friends.FriendsInteractor;
import aut.bme.hu.interactor.friends.UsersDownloadedEvent;
import aut.bme.hu.ui.Presenter;
import aut.bme.hu.ui.friends.list.UserRow;
import io.swagger.client.model.Person;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class FriendsPresenter extends Presenter<FriendsScreen>{

    @Inject
    FriendsInteractor friendsInteractor;

    List<Person> friends;

    List<Person> users;

    private Executor networkExecutor =  Executors.newFixedThreadPool(1);


    public FriendsPresenter(){
        SocialApplication.injector.inject(this);
    }

    public void listFriends(){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                friendsInteractor.listFriends();
            }
        });
    }

    public void listUsers(){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                friendsInteractor.listUsers();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFriendsFetched(FriendsDownloadedEvent event){
        this.friends = event.getFriends();

        if (users != null){
            mergeFriends();
        }

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUsersFetched(UsersDownloadedEvent event){
        this.users = event.getFriends();
        if (friends != null){
            mergeFriends();
        }
    }


    private void mergeFriends() {
        List<UserRow> rows = new ArrayList<>();
        users.removeAll(friends);

        for (Person  p: friends) {
            UserRow userRow = new UserRow();
            userRow.setFriend(true);
            userRow.setPerson(p);
            rows.add(userRow);
        }

        for (Person p : users) {
            UserRow userRow = new UserRow();
            userRow.setFriend(false);
            userRow.setPerson(p);
            rows.add(userRow);
        }

        screen.onFriendsArrived(rows);

    }


    public void userClicked(UserRow user) {
        user.setFriend(true);
        screen.updateList();
    }

}
