package com.example.al.daggertest.component;

import com.example.al.daggertest.BaseActivity;
import com.example.al.daggertest.MainActivity;
import com.example.al.daggertest.module.AppModule;
import com.example.al.daggertest.scope.PerApplication;

import dagger.Component;

/**
 * Created by al on 13.08.16.
 */

@PerApplication
@Component(modules={AppModule.class})
public interface FragmentComponent {
    void inject(MainActivity activity);
    void inject(BaseActivity activity);
}

