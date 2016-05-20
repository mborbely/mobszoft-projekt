package aut.bme.hu.ui.frienddetail;


import io.swagger.client.model.PersonDetails;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public interface FriendDetailsScreen {

    void navigateBack();

    void displayFriend(PersonDetails friend);

}
