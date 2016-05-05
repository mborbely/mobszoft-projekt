package aut.bme.hu.service.friends;

import java.util.List;

import aut.bme.hu.orm.Friend;

public class FriendsDownloadedEvent {
    List<Friend> friends;

    public FriendsDownloadedEvent(List<Friend> friends) {
        this.friends = friends;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
