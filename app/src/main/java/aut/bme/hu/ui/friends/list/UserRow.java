package aut.bme.hu.ui.friends.list;

import io.swagger.client.model.Person;

public class UserRow {
    private Person person;

    private boolean friend;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isFriend() {
        return friend;
    }

    public void setFriend(boolean friend) {
        this.friend = friend;
    }
}
