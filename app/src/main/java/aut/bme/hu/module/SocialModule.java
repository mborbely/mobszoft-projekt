package aut.bme.hu.module;

import javax.inject.Singleton;

import aut.bme.hu.interactor.friends.FriendsInteractor;
import aut.bme.hu.interactor.friends.FriendsInteractorImpl;
import aut.bme.hu.interactor.login.LoginInteractor;
import aut.bme.hu.interactor.login.LoginInteractorImpl;
import aut.bme.hu.interactor.profile.ProfileInteractor;
import aut.bme.hu.interactor.profile.ProfileInteractorImpl;
import aut.bme.hu.interactor.register.RegisterInteractor;
import aut.bme.hu.interactor.register.RegisterInteractorImpl;
import aut.bme.hu.ui.frienddetail.FriendDetailsPresenter;
import aut.bme.hu.ui.friends.FriendsPresenter;
import aut.bme.hu.ui.login.LoginPresenter;
import aut.bme.hu.ui.profile.RegisterPresenter;
import dagger.Module;
import dagger.Provides;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.api.DefaultApiImpl;

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
    RegisterPresenter provideEditProfilePresenter(){
        return new RegisterPresenter();
    }

    @Provides @Singleton
    DefaultApi provideDefaultApi(){
        return new DefaultApiImpl();
    }


    @Provides @Singleton
    RegisterInteractor provideRegisterInteractor(){
        return new RegisterInteractorImpl();
    }
}
