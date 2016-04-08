package aut.bme.hu.ui;

import android.app.Application;

import javax.inject.Inject;

import aut.bme.hu.app.SocialApplication;
import aut.bme.hu.service.LoginService;

/**
 * Created by mobsoft on 2016. 04. 08..
 */
public class LoginPresenter extends Presenter<LoginScreen>{

    @Inject
    LoginService loginService;

    public LoginPresenter(){
        SocialApplication.injector.inject(this);
    }

    public void login(String email, String password){
        boolean success = loginService.login(email, password);

        if (success){
            screen.loginSuccess();
        }

    }


}
