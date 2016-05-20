package aut.bme.hu.interactor.friends;

import java.util.List;

import io.swagger.client.model.Person;

public class UsersDownloadedEvent {
    List<Person> friends;

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public UsersDownloadedEvent(List<Person> friends) {
        this.friends = friends;
    }
}
