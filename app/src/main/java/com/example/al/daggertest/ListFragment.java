package com.example.al.daggertest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.al.daggertest.component.DaggerListFragmentComponent;
import com.example.al.daggertest.module.FragmentListModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by al on 14.08.16.
 */
public class ListFragment extends Fragment {


    @Inject @Named(FragmentListModule.NAMED.FRAGMENT_LIST_CONTEXT) Context mContext;
    @Inject MyListAdapter mAdapter;
    @Inject RecyclerView.LayoutManager mLayoutManager;
    @Inject @Named(FragmentListModule.NAMED.FRAG_TITLE) String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        TestApp ta = (TestApp) getActivity().getApplication();

        DaggerListFragmentComponent.builder()
                .fragmentListModule(new FragmentListModule(this))
                .appComponent(ta.getAppComponent())
                .build()
                .inject(this);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        TextView titleView = (TextView) v.findViewById(R.id.title);
        titleView.setText(title);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        return v;
    }
}
