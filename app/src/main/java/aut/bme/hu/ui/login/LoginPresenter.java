package aut.bme.hu.ui.login;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.service.login.LoginInteractor;
import aut.bme.hu.ui.Presenter;

/**
 * Created by mobsoft on 2016. 04. 08..
 */
public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    LoginInteractor loginInteractor;

    public LoginPresenter(){
        SocialApplication.injector.inject(this);
    }

    public void login(String email, String password){
        boolean success = loginInteractor.login(email, password);

        if (success){
            screen.loginSuccess();
        }

    }


}
