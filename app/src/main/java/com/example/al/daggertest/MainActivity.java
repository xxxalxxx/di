package com.example.al.daggertest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import com.example.al.daggertest.component.AppComponent;
import com.example.al.daggertest.module.AppModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends BaseActivity {

    @Inject @Named(AppModule.NAME_APP_NAME) String appName;
    @Inject @Named(AppModule.NAME_BASE_CONTEXT) Context baseContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText(appName);
        Log.d("__CTX", "c:" + (baseContext == this));
    }

    @Override
    protected void injectComponent(AppComponent comp) {
        comp.inject(this);
    }


}
