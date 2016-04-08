package aut.bme.hu.module;

import javax.inject.Singleton;

import aut.bme.hu.service.LoginService;
import aut.bme.hu.service.LoginServiceImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 04. 08..
 */

@Module
public class SocialModule {

    @Provides @Singleton
    LoginService provideLoginService(){
        return new LoginServiceImpl();
    }
}
