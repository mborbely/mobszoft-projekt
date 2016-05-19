package aut.bme.hu.ui.friends.list;

import aut.bme.hu.model.User;

public class UserRow {
    private User user;

    private boolean friend;

    public UserRow(User user, boolean friend) {
        this.user = user;
        this.friend = friend;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isFriend() {
        return friend;
    }

    public void setFriend(boolean friend) {
        this.friend = friend;
    }
}
