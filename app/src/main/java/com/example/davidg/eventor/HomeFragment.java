package com.example.davidg.eventor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.davidg.eventor.Api.CallEventApi;
import com.example.davidg.eventor.Api.ObservableEventApi;
import com.example.davidg.eventor.Model.Embedded;
import com.example.davidg.eventor.adapter.EventAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DavidG on 14/03/2018.
 */

public class HomeFragment extends Fragment {


    View view;
    private RecyclerView recyclerView;
    private ObservableEventApi apiservice;

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
        view = inflater.inflate( R.layout.fragment_home, container, false );
        doNetworkCall();
        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle( "HOME" );


    }


    private void doNetworkCall() {




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://app.ticketmaster.com/" )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        apiservice = retrofit.create( ObservableEventApi.class );
        apiservice.getEvent()
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<Embedded>() {


                    @Override
                    public void accept(Embedded embedded) throws Exception {
                        recyclerView.setAdapter( new EventAdapter( embedded.getEvents() ) );
                        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
                        Toast.makeText( getActivity(), "EEEEEEEVVVVEEEENNT", Toast.LENGTH_SHORT ).show();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText( getActivity(), "SORRY", Toast.LENGTH_LONG ).show();
                    }
                } );


    }
}






