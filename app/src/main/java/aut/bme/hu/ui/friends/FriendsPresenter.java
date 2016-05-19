package aut.bme.hu.ui.friends;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.interactor.friends.FriendsInteractor;
import aut.bme.hu.ui.Presenter;
import aut.bme.hu.ui.friends.list.UserRow;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class FriendsPresenter extends Presenter<FriendsScreen>{

    @Inject
    FriendsInteractor friendsInteractor;

    public FriendsPresenter(){
        SocialApplication.injector.inject(this);
    }

    public void listFriends(){
        friendsInteractor.listFriends();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFriendsFetched(FriendsFetchedEvent event){
        screen.onFriendsArrived(event.friends);
    }

    public void userClicked(UserRow user) {
        user.setFriend(true);
        screen.updateList();
    }

}
