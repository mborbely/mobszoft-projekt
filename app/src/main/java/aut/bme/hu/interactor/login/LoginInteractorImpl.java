package aut.bme.hu.interactor.login;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import io.swagger.client.api.DefaultApi;
import io.swagger.client.api.DefaultApiImpl;
import io.swagger.client.model.Login;
import retrofit2.Response;

/**
 * Created by mobsoft on 2016. 04. 08..
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Inject
    DefaultApi defaultApi;


    public LoginInteractorImpl(){
        defaultApi = new DefaultApiImpl();
    }

    @Override
    public void login(String email, String password) {
        Log.i("LoginInteractorImpl", email);

        try {
            Response<Boolean> response = defaultApi.login(new Login(email, password)).execute();
            if (response.body()){
                EventBus.getDefault().post(new SuccessfulLoginEvent());
            } else {
                //TODO fail
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
