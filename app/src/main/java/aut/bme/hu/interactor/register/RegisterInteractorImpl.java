package aut.bme.hu.interactor.register;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import io.swagger.client.api.DefaultApi;
import io.swagger.client.api.DefaultApiImpl;
import retrofit2.Response;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class RegisterInteractorImpl implements RegisterInteractor {

    @Inject
    DefaultApi defaultApi;


    public RegisterInteractorImpl(){
        defaultApi = new DefaultApiImpl();
    }


    @Override
    public void register(io.swagger.client.model.Registration registration) {
        try {

            Response<io.swagger.client.model.Registration> response = defaultApi.usersPost(registration).execute();

            EventBus.getDefault().post(new RegistrationSuccessfulEvent(response.body()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
