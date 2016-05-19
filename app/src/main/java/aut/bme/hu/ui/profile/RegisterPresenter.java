package aut.bme.hu.ui.profile;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.interactor.register.RegisterInteractor;
import aut.bme.hu.interactor.register.RegistrationSuccessfulEvent;
import aut.bme.hu.ui.Presenter;
import io.swagger.client.model.Registration;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class RegisterPresenter extends Presenter<RegisterScreen>{

    private Executor networkExecutor =  Executors.newFixedThreadPool(1);

    @Inject
    RegisterInteractor registerInteractor;


    public RegisterPresenter(){
        SocialApplication.injector.inject(this);
    }


    public void register(final Registration profile){

        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                registerInteractor.register(profile);
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onProfileDataSaved(RegistrationSuccessfulEvent event){
        screen.onProfileDataSaved();
    }


}
