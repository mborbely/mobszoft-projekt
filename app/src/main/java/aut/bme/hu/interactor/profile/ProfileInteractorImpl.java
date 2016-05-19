package aut.bme.hu.interactor.profile;

import org.greenrobot.eventbus.EventBus;

import io.swagger.client.model.Registration;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class ProfileInteractorImpl implements ProfileInteractor {

    @Override
    public void getProfile() {

    }

    @Override
    public void saveProfile(Registration profile) {
        EventBus.getDefault().post(new RegistratedEvent(profile));
    }
}
