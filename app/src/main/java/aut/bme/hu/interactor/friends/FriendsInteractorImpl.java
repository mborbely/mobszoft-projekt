package aut.bme.hu.interactor.friends;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import io.swagger.client.api.DefaultApi;
import io.swagger.client.api.DefaultApiImpl;
import io.swagger.client.model.Person;
import io.swagger.client.model.PersonDetails;
import retrofit2.Response;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class FriendsInteractorImpl implements FriendsInteractor {

    @Inject
    DefaultApi defaultApi;

    public FriendsInteractorImpl(){
        defaultApi = new DefaultApiImpl();
    }

    @Override
    public void listFriends() {
        try {
            Response<List<Person>> response = defaultApi.friendsGet().execute();
            EventBus.getDefault().post(new FriendsDownloadedEvent(response.body()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listUsers() {
        try {
            Response<List<Person>> response = defaultApi.usersGet().execute();
            EventBus.getDefault().post(new UsersDownloadedEvent(response.body()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFriendById(BigDecimal id) {
        try {
            Response<PersonDetails> response = defaultApi.friendsPersonIdGet(id).execute();
            EventBus.getDefault().post(new FriendDetailsLoadedEvent(response.body()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
