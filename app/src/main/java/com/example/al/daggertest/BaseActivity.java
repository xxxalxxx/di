package com.example.al.daggertest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.al.daggertest.component.AppComponent;

/**
 * Created by al on 14.08.16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent component = ((TestApp)getApplication()).getAppComponent();
        injectComponent(component);
    }

    protected abstract void injectComponent(AppComponent comp);

}
