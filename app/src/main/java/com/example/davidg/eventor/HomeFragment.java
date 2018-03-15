package com.example.davidg.eventor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.davidg.eventor.Api.CallEventApi;
import com.example.davidg.eventor.Api.ObservableEventApi;
import com.example.davidg.eventor.Model.Embedded;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DavidG on 14/03/2018.
 */

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate( R.layout.fragment_home, container, false );
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle( "HOME" );

//        EventCall();
    }


    private void EventCall() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://app.ticketmaster.com/" )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        CallEventApi apiservice = retrofit.create( CallEventApi.class );

        Call<List<Embedded>> call = apiservice.getEvent();

        call.enqueue( new Callback<List<Embedded>>() {
            @Override
            public void onResponse(Call<List<Embedded>> call, Response<List<Embedded>> response) {

                Toast.makeText( getActivity(), "Helloooo", Toast.LENGTH_LONG ).show();


            }

            @Override
            public void onFailure(Call<List<Embedded>> call, Throwable t) {


            }
        } );


    }
}
