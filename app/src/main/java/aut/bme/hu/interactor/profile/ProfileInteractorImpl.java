package aut.bme.hu.interactor.profile;

import org.greenrobot.eventbus.EventBus;

import aut.bme.hu.model.User;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class ProfileInteractorImpl implements ProfileInteractor {

    @Override
    public void getProfile() {

    }

    @Override
    public void saveProfile(User profile) {
        EventBus.getDefault().post(new RegistratedEvent(profile));
    }
}
