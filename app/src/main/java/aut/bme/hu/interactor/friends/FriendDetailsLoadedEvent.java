package aut.bme.hu.interactor.friends;

import io.swagger.client.model.PersonDetails;

public class FriendDetailsLoadedEvent {

    PersonDetails personDetails;

    public FriendDetailsLoadedEvent(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }
}
