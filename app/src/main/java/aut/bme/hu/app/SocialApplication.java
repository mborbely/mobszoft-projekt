package aut.bme.hu.app;

import com.orm.SugarApp;

import aut.bme.hu.module.DaggerSocialComponent;
import aut.bme.hu.module.SocialComponent;
import aut.bme.hu.module.SocialModule;

/**
 * Created by mobsoft on 2016. 04. 08..
 */
public class SocialApplication extends SugarApp {

    public static SocialComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerSocialComponent.builder().socialModule(new SocialModule()).build();
    }
}
