package aut.bme.hu.service.login;

import android.util.Log;

/**
 * Created by mobsoft on 2016. 04. 08..
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public boolean login(String email, String password) {
        Log.i("LoginInteractorImpl", email);
        return true;
    }
}
