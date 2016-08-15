package com.example.al.daggertest.component;

import com.example.al.daggertest.ListFragment;
import com.example.al.daggertest.module.FragmentListModule;
import com.example.al.daggertest.scope.PerApplication;
import com.example.al.daggertest.scope.PerListFragment;

import dagger.Component;

/**
 * Created by al on 13.08.16.
 */

@PerListFragment
@Component(modules={FragmentListModule.class}, dependencies = {AppComponent.class})
public interface ListFragmentComponent {
    void inject(ListFragment fragment);
}

