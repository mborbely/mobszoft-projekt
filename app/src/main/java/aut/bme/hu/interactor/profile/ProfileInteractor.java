package aut.bme.hu.interactor.profile;

import io.swagger.client.model.Registration;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public interface ProfileInteractor {

    void getProfile();

    void saveProfile(Registration profile);

}
