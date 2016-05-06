package aut.bme.hu.orm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mobsoft on 2016. 05. 06..
 */
public class FriendsRepositoryInMemoryImpl implements FriendRepository {

    private Map<Long, FriendEntity> friends = new HashMap<>();

    @Override
    public FriendEntity getFriendById(Long id) {
        return friends.get(id);
    }

    @Override
    public void createFriend(FriendEntity friend) {
        friends.put(friend.getId(), friend);
    }

    @Override
    public void updateFriend(FriendEntity friend) {
        friends.put(friend.getId(), friend);
    }

    @Override
    public void deleteFriend(FriendEntity friend) {
        friends.remove(friend.getId());
    }

    @Override
    public List<FriendEntity> listFriends() {
        return new ArrayList<>(friends.values());
    }
}
