package com.app.propertylist.di;

import com.app.propertylist.MainActivity;
import com.app.propertylist.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);
    void inject(BaseFragment fragment);
}