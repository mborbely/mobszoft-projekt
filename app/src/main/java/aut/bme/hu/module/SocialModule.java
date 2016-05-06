package aut.bme.hu.module;

import javax.inject.Singleton;

import aut.bme.hu.service.friends.FriendsInteractor;
import aut.bme.hu.service.friends.FriendsInteractorImpl;
import aut.bme.hu.service.login.LoginInteractor;
import aut.bme.hu.service.login.LoginInteractorImpl;
import aut.bme.hu.service.profile.ProfileInteractor;
import aut.bme.hu.service.profile.ProfileInteractorImpl;
import aut.bme.hu.ui.frienddetail.FriendDetailsPresenter;
import aut.bme.hu.ui.friends.FriendsPresenter;
import aut.bme.hu.ui.login.LoginPresenter;
import aut.bme.hu.ui.profile.EditProfilePresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 04. 08..
 */

@Module
public class SocialModule {

    @Provides @Singleton
    LoginInteractor provideLoginService(){
        return new LoginInteractorImpl();
    }

    @Provides @Singleton
    LoginPresenter provideLoginPresenter(){
        return new LoginPresenter();
    }

    @Provides @Singleton
     FriendsInteractor provideFriendsService(){
        return new FriendsInteractorImpl();
    }

    @Provides @Singleton
    FriendsPresenter provideFriendsPresenter(){
        return new FriendsPresenter();
    }

    @Provides @Singleton
    FriendDetailsPresenter provideFriendDetailsPresenter(){
        return new FriendDetailsPresenter();
    }

    @Provides @Singleton
    ProfileInteractor provideProfileInteractor(){
        return new ProfileInteractorImpl();
    }

    @Provides @Singleton
    EditProfilePresenter provideEditProfilePresenter(){
        return new EditProfilePresenter();
    }
}
