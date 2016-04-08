package aut.bme.hu.module;

import javax.inject.Singleton;

import aut.bme.hu.mobszoft_projekt.MainActivity;
import aut.bme.hu.service.LoginService;
import dagger.Component;

/**
 * Created by mobsoft on 2016. 04. 08..
 */
@Singleton
@Component(modules = {SocialModule.class})
public interface SocialComponent {

    LoginService provideLoginService();

    void inject(MainActivity mainActivity);

}