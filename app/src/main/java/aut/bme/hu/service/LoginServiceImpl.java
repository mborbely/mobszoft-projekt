package aut.bme.hu.service;

import android.util.Log;

import javax.inject.Singleton;

import aut.bme.hu.module.SocialModule;
import dagger.Component;

/**
 * Created by mobsoft on 2016. 04. 08..
 */

public class LoginServiceImpl implements LoginService{

    @Override
    public boolean login(String email, String password) {
        Log.i("LoginServiceImpl", email);
        return true;
    }
}
