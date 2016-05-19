package aut.bme.hu.interactor.friends;

import java.util.List;

import aut.bme.hu.orm.FriendEntity;

public class FriendsDownloadedEvent {
    List<FriendEntity> friends;

    public FriendsDownloadedEvent(List<FriendEntity> friends) {
        this.friends = friends;
    }

    public List<FriendEntity> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendEntity> friends) {
        this.friends = friends;
    }
}
