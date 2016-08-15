package com.example.al.daggertest.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.al.daggertest.MyListAdapter;
import com.example.al.daggertest.component.AppComponent;
import com.example.al.daggertest.scope.PerApplication;
import com.example.al.daggertest.scope.PerFragment;
import com.example.al.daggertest.scope.PerListFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by al on 13.08.16.
 */

@Module
public class FragmentListModule {

    public interface NAMED {
        String
                FRAGMENT_LIST_CONTEXT = "fragmentListContext",
                FRAG_TITLE = "fragTitle";
    }

    Fragment mFragment;

    public FragmentListModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerListFragment
    @Named(NAMED.FRAGMENT_LIST_CONTEXT)
    public Context context() {
        return mFragment.getContext();
    }

    @Provides
    @PerListFragment
    public MyListAdapter adapter() {
        return new MyListAdapter();
    }

    @Provides
    @PerListFragment
    public RecyclerView.LayoutManager layoutManager() {
        return new LinearLayoutManager(context(), LinearLayoutManager.HORIZONTAL,false);
    }

    @Provides
    @PerListFragment
    @Named(FragmentListModule.NAMED.FRAG_TITLE)
    public String fragTitle(@Named(AppModule.NAME_APP_NAME) String s) {
        return "title: " + s;
    }

}
