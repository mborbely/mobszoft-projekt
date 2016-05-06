package aut.bme.hu.service.profile;

import aut.bme.hu.model.User;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public interface ProfileInteractor {

    void getProfile();

    void updateProfile(User profile);

}
