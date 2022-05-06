package com.example.eventsdemo.retrofit

import Event
import com.example.eventsdemo.response.EventResponse
import com.example.eventsdemo.utils.ApiConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RetrofitApi {
    @GET("discovery/v2/events.json")
    fun getEvents(@QueryMap params: HashMap<String, String>): Call<EventResponse>
}