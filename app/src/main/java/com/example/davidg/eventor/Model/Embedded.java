package com.example.davidg.eventor.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by DavidG on 14/03/2018.
 */

public class Embedded {


    @SerializedName("eventcount")
    @Expose
    private Integer eventcount;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    public Integer getEventcount() {
        return eventcount;
    }

    public void setEventcount(Integer eventcount) {
        this.eventcount = eventcount;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}

