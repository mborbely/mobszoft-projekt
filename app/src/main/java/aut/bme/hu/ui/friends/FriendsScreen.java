package aut.bme.hu.ui.friends;

import java.util.List;

import aut.bme.hu.ui.friends.list.UserRow;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public interface FriendsScreen {
    void updateList();

    void addFriendSuccess();

    void onFriendsArrived(List<UserRow> friends );


}
