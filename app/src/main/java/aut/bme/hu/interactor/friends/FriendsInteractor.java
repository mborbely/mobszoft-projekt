package aut.bme.hu.interactor.friends;

import java.math.BigDecimal;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public interface FriendsInteractor {

    void listFriends();

    void listUsers();

    void getFriendById(BigDecimal id);

}
