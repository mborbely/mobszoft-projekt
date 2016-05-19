package aut.bme.hu.interactor.register;


import io.swagger.client.model.Registration;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class RegistrationSuccessfulEvent {
    private Registration registration;

    public RegistrationSuccessfulEvent(Registration registration) {
        this.registration = registration;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}
