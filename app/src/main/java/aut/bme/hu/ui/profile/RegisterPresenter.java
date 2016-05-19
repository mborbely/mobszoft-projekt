package aut.bme.hu.ui.profile;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.interactor.profile.RegistratedEvent;
import aut.bme.hu.interactor.register.RegisterInteractor;
import aut.bme.hu.ui.Presenter;
import io.swagger.client.model.Registration;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class RegisterPresenter extends Presenter<RegisterScreen>{

    @Inject
    RegisterInteractor registerInteractor;


    public RegisterPresenter(){
        SocialApplication.injector.inject(this);
    }


    public void register(Registration profile){
        registerInteractor.register(profile);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onProfileDataSaved(RegistratedEvent event){
        screen.onProfileDataSaved();
    }


}
