package com.example.eventsdemo.ui

import Event
import android.annotation.SuppressLint
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eventsdemo.R
import com.example.eventsdemo.response.EventResponse
import com.example.eventsdemo.utils.ApiConstants
import com.example.eventsdemo.utils.ApiConstants.EVENT_LIST_SIZE
import com.example.eventsdemo.utils.IConstants
import com.example.eventsdemo.utils.isNetworkAvailable
import retrofit2.Response

class EventViewModel(application: Application) : AndroidViewModel(application) {

    val eventLiveData = MutableLiveData<Response<EventResponse>>()
    val errorLiveData = MutableLiveData<String>()
    private val eventRepository = EventRepository()


    fun callGetEventApi() {
        val inputParams = HashMap<String, String>()
        inputParams[ApiConstants.SIZE] = EVENT_LIST_SIZE
        inputParams[ApiConstants.APIKEY] = IConstants.API_KEY
        eventRepository.getEventList(inputParams, eventLiveData, errorLiveData)


    }


}