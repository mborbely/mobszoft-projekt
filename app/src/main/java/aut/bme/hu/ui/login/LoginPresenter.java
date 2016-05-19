package aut.bme.hu.ui.login;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.interactor.login.LoginInteractor;
import aut.bme.hu.interactor.login.SuccessfulLoginEvent;
import aut.bme.hu.ui.Presenter;

/**
 * Created by mobsoft on 2016. 04. 08..
 */
public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    LoginInteractor loginInteractor;

    private Executor networkExecutor =  Executors.newFixedThreadPool(1);


    public LoginPresenter(){
        SocialApplication.injector.inject(this);
    }

    public void login(final String email, final String password){

        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                loginInteractor.login(email, password);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccess(SuccessfulLoginEvent successfulLoginEvent){
        screen.loginSuccess();
    }


}
