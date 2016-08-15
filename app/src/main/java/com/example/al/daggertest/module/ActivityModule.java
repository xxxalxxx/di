package com.example.al.daggertest.module;

import android.support.v7.app.AppCompatActivity;

import com.example.al.daggertest.scope.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by al on 14.08.16.
 */

@Module
@PerActivity
public class ActivityModule {

    public static final String
            NAMED_ACTIVITY_NAME = "activityName";

    AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }


    @Provides
    @Named(NAMED_ACTIVITY_NAME)
    @PerActivity
    public String getActivityName() {
        return "activity name";
    }

}
