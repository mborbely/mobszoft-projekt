package aut.bme.hu.orm;

import java.util.List;

/**
 * Created by mobsoft on 2016. 05. 06..
 */
public class FriendsRepositoryImpl implements FriendRepository {

    @Override
    public FriendEntity getFriendById(Long id) {
        return FriendEntity.findById(FriendEntity.class, id);
    }

    @Override
    public void createFriend(FriendEntity friend) {
         FriendEntity.save(friend);
    }

    @Override
    public void updateFriend(FriendEntity friend) {
        FriendEntity.save(friend);
    }

    @Override
    public void deleteFriend(FriendEntity friend) {
        FriendEntity.delete(friend);
    }

    @Override
    public List<FriendEntity> listFriends() {
        return FriendEntity.listAll(FriendEntity.class);
    }
}
