package aut.bme.hu.orm;

import java.util.List;

/**
 * Created by mobsoft on 2016. 05. 06..
 */
public interface FriendRepository {

    FriendEntity getFriendById(Long id);

    void createFriend(FriendEntity friend);

    void updateFriend(FriendEntity friend);

    void deleteFriend(FriendEntity friend);

    List<FriendEntity> listFriends();


}
