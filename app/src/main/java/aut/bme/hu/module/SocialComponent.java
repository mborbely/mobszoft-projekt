package aut.bme.hu.module;

import javax.inject.Singleton;

import aut.bme.hu.mobszoft_projekt.LoginActivity;
import aut.bme.hu.service.friends.FriendsInteractor;
import aut.bme.hu.service.login.LoginInteractor;
import aut.bme.hu.ui.friends.FriendsPresenter;
import aut.bme.hu.ui.login.LoginPresenter;
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

}