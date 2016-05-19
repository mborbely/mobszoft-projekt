package aut.bme.hu.interactor.profile;


import io.swagger.client.model.Registration;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class RegistratedEvent {
    private Registration registration;

    public RegistratedEvent(Registration registration) {
        this.registration = registration;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}
