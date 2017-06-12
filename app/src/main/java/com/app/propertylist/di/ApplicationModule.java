package com.app.propertylist.di;

import com.app.propertylist.network.PropertyService;
import com.app.propertylist.network.RequestManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    public ApplicationModule() {
    }

    @Provides
    @Singleton
    RequestManager providesRequestManager() {
        return new RequestManager();
    }
}