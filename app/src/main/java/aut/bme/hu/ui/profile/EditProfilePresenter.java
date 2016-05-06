package aut.bme.hu.ui.profile;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.model.User;
import aut.bme.hu.service.friends.FriendsInteractor;
import aut.bme.hu.service.profile.ProfileDataFetchedEvent;
import aut.bme.hu.ui.Presenter;
import aut.bme.hu.ui.friends.FriendsScreen;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class EditProfilePresenter extends Presenter<FriendsScreen>{

    @Inject
    FriendsInteractor friendsInteractor;


    public EditProfilePresenter(){
        SocialApplication.injector.inject(this);
    }


    public void saveProfile(User profile){

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onProfileDataArrived(ProfileDataFetchedEvent event){

    }


}
