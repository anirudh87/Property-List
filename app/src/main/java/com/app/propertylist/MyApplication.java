package com.app.propertylist;

import android.app.Application;

import com.app.propertylist.di.ApplicationComponent;
import com.app.propertylist.di.ApplicationModule;
import com.app.propertylist.di.DaggerApplicationComponent;

public class MyApplication extends Application {
    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
