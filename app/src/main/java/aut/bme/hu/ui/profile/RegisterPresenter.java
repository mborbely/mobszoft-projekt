package aut.bme.hu.ui.profile;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.interactor.profile.ProfileDataSavedEvent;
import aut.bme.hu.interactor.profile.ProfileInteractor;
import aut.bme.hu.model.Registration;
import aut.bme.hu.ui.Presenter;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class RegisterPresenter extends Presenter<RegisterScreen>{

    @Inject
    ProfileInteractor profileInteractor;


    public RegisterPresenter(){
        SocialApplication.injector.inject(this);
    }


    public void saveProfile(Registration profile){
        profileInteractor.saveProfile(profile);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onProfileDataSaved(ProfileDataSavedEvent event){
        screen.onProfileDataSaved();
    }


}
