package com.example.al.daggertest.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.StringBuilderPrinter;

import com.example.al.daggertest.scope.PerApplication;

import javax.annotation.security.PermitAll;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by al on 13.08.16.
 */

@Module
public class AppModule {

    public static final String
            NAME_APP_NAME = "appName",
            NAME_APP_CONTEXT = "appContext",
            NAME_BASE_CONTEXT = "baseContext";


    Application mApp;

    public AppModule(Application app) {
        mApp = app;
    }

    @Provides
    @PerApplication
    public Application provideApplication() {
        return mApp;
    }

    @Provides
    @Named(NAME_APP_CONTEXT)
    public Context provideAppContext() {
        return mApp.getApplicationContext();
    }

    @Provides
    @Named(NAME_BASE_CONTEXT)
    public Context provideBaseContext() {
        return mApp.getBaseContext();
    }

    @Provides
    public Resources provideResources() {
        return provideAppContext().getResources();
    }

    @Provides
    @PerApplication
    public SharedPreferences providePrefs() {
        return PreferenceManager.getDefaultSharedPreferences(provideAppContext());
    }

    @Provides
    @PerApplication
    @Named(NAME_APP_NAME)
    public String provideAppName() {
        return "TestApp";
    }
}
