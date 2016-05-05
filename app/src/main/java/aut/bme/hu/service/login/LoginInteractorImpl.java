package aut.bme.hu.service.login;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mobsoft on 2016. 04. 08..
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(String email, String password) {
        Log.i("LoginInteractorImpl", email);
        EventBus.getDefault().post(new SuccessfulLoginEvent());
    }
}
