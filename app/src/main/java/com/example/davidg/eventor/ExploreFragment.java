package com.example.davidg.eventor;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DavidG on 14/03/2018.
 */

public class ExploreFragment extends Fragment {

    View view;


    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
//        doNetworkCall();

        return view = inflater.inflate( R.layout.fragment_explore, container, false );


    }

    private void doNetworkCall() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://app.ticketmaster.com/" )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle( "EXPLORE" );
    }
}
