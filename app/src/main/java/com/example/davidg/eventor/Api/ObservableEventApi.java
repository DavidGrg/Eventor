package com.example.davidg.eventor.Api;

import com.example.davidg.eventor.Model.Embedded;
import com.example.davidg.eventor.Model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by DavidG on 14/03/2018.
 */

public interface ObservableEventApi {

    @GET("discovery/v2/events.json?apikey=oxutmWcAX9bC8A3DFFqGRLsJyCHszq9c")
    Observable<Embedded> getEvent();
}
