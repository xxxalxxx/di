package com.example.al.daggertest;

import android.app.Application;

import com.example.al.daggertest.component.AppComponent;
import com.example.al.daggertest.component.DaggerAppComponent;
import com.example.al.daggertest.module.AppModule;

/**
 * Created by al on 13.08.16.
 */
public class TestApp extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                // list of modules that are part of this component need to be created here too.daggerAppModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
