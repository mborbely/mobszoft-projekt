package aut.bme.hu.ui.frienddetail;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.math.BigDecimal;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.interactor.friends.FriendDetailsLoadedEvent;
import aut.bme.hu.interactor.friends.FriendsInteractor;
import aut.bme.hu.ui.Presenter;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class FriendDetailsPresenter extends Presenter<FriendDetailsScreen>{

    @Inject
    FriendsInteractor friendsInteractor;

    private Executor networkExecutor =  Executors.newFixedThreadPool(1);



    public FriendDetailsPresenter(){
        SocialApplication.injector.inject(this);
    }


    public void getFriendDetails(final BigDecimal id){

        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                friendsInteractor.getFriendById(id);
            }
        });


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFriendDetailsFetched(FriendDetailsLoadedEvent event){
        screen.displayFriend(event.getPersonDetails());
    }


}
