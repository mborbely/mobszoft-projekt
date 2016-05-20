package aut.bme.hu.ui.frienddetail;

import io.swagger.client.model.PersonDetails;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class FriendDetailsFetchedEvent {
    public PersonDetails personDetails;

    public FriendDetailsFetchedEvent(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }
}
