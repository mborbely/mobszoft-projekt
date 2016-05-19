package aut.bme.hu.ui.frienddetail;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.interactor.friends.FriendsInteractor;
import aut.bme.hu.ui.Presenter;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class FriendDetailsPresenter extends Presenter<FriendDetailsScreen>{

    @Inject
    FriendsInteractor friendsInteractor;


    public FriendDetailsPresenter(){
        SocialApplication.injector.inject(this);
    }

    public void listFriends(){

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFriendDetailsFetched(FriendDetailsFetchedEvent event){

    }


}
