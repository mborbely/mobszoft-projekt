package aut.bme.hu.app;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.orm.SugarApp;

import aut.bme.hu.mobszoft_projekt.R;
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

    private static Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link android.app.Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

}
