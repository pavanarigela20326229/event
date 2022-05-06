package com.example.eventsdemo.ui

import Event
import androidx.lifecycle.MutableLiveData
import com.example.eventsdemo.response.EventResponse
import com.example.eventsdemo.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventRepository {


    fun getEventList(
        inputParams: HashMap<String, String>,
        eventLiveData: MutableLiveData<Response<EventResponse>>,
        errorLiveData: MutableLiveData<String>
    ) {
        RetrofitClient.getRetrofitClient().getEvents(inputParams)
            .enqueue(object : Callback<EventResponse> {
                override fun onResponse(
                    call: Call<EventResponse>,
                    response: Response<EventResponse>
                ) {
                    eventLiveData.postValue(response)
                }

                override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                    errorLiveData.postValue(t.message)
                }

            })
    }
}