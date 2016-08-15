package com.example.al.daggertest.component;

import android.app.Application;

import com.example.al.daggertest.BaseActivity;
import com.example.al.daggertest.MainActivity;
import com.example.al.daggertest.module.AppModule;
import com.example.al.daggertest.scope.PerApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by al on 13.08.16.
 */

@PerApplication
@Component(modules={AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(BaseActivity activity);

        Application app();

        @Named(AppModule.NAME_APP_NAME) String name();
}

