package aut.bme.hu.module;

import javax.inject.Singleton;

import aut.bme.hu.interactor.friends.FriendsInteractor;
import aut.bme.hu.interactor.login.LoginInteractor;
import aut.bme.hu.mobszoft_projekt.LoginActivity;
import aut.bme.hu.ui.frienddetail.FriendDetailsActivity;
import aut.bme.hu.ui.frienddetail.FriendDetailsPresenter;
import aut.bme.hu.ui.friends.FriendsActivity;
import aut.bme.hu.ui.friends.FriendsPresenter;
import aut.bme.hu.ui.login.LoginPresenter;
import aut.bme.hu.ui.profile.RegisterActivity;
import aut.bme.hu.ui.profile.RegisterPresenter;
import dagger.Component;

/**
 * Created by mobsoft on 2016. 04. 08..
 */
@Singleton
@Component(modules = {SocialModule.class})
public interface SocialComponent {

    LoginInteractor provideLoginService();

    void inject(LoginActivity loginActivity);

    void inject(LoginPresenter loginPresenter);

    void inject(FriendsInteractor friendsInteractor);

    void inject(FriendsPresenter friendsPresenter);

    void inject (FriendDetailsPresenter friendDetailsPresenter);

    void inject (RegisterPresenter friendDetailsPresenter);

    void inject (RegisterActivity registerActivity);

    void inject (FriendDetailsActivity friendDetailsActivity);

    void inject (FriendsActivity friendsActivity);


}