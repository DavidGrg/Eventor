package com.example.davidg.eventor.Api;

import com.example.davidg.eventor.Model.Embedded;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DavidG on 15/03/2018.
 */

public interface CallEventApi {


    @GET("discovery/v2/events.json?apikey=oxutmWcAX9bC8A3DFFqGRLsJyCHszq9c")
    Call<List<Embedded>> getEvent();
}
