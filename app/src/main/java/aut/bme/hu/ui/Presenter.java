package aut.bme.hu.ui;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mobsoft on 2016. 04. 08..
 */

public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
        EventBus.getDefault().register(this);
    }

    public void detachScreen() {
        this.screen = null;
        EventBus.getDefault().unregister(this);
    }
}
