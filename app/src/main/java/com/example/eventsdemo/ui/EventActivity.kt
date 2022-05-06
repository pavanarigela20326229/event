package com.example.eventsdemo.ui

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.eventsdemo.R
import com.example.eventsdemo.core.BaseActivity
import com.example.eventsdemo.databinding.ActivityEventBinding
import com.example.eventsdemo.utils.*

/**
 * this activity is used to show event list
 */
class EventActivity : BaseActivity<ActivityEventBinding>() {
    private var backPressedTime: Long = 0
    private lateinit var eventAdapter: EventAdapter
    private lateinit var eventViewModel: EventViewModel

    override fun getLayout(): Int {
        return R.layout.activity_event
    }

    override fun initView() {
        eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)
        addObserver()
        setUpEventAdapter()
        binding.swipeRefresh.setOnRefreshListener {
            callGetEventApi(false)

        }
        callGetEventApi(true)

    }

    private fun setUpEventAdapter() {
        eventAdapter = EventAdapter {
            val intent = Intent(this, EventDetailsActivity::class.java)
            intent.putExtra(IConstants.EVENT, it)
            startActivity(intent)
        }
        binding.rvEvents.adapter = eventAdapter
    }

    private fun addObserver() {
        eventViewModel.eventLiveData.observe(this) {
            if (it.isSuccessful && it.body() != null && it.body()!!.embedded.events.isNotEmpty()) {
                eventAdapter.setUpData(it.body()!!.embedded.events)
                binding.tvNoData.gone()
            } else {
                binding.tvNoData.visible()
            }
            binding.swipeRefresh.isRefreshing = false
            showDialog(false)
        }

        eventViewModel.errorLiveData.observe(this) {
            binding.swipeRefresh.isRefreshing = false
            this.showToast(it)
            showDialog(false)
        }
    }

    private fun callGetEventApi(isShowLoader: Boolean) {
        if (this.isNetworkAvailable()) {
            showDialog(isShowLoader)
            eventViewModel.callGetEventApi()
        } else {
            Toast.makeText(
                this,
                getString(R.string.please_check_internet_connection),
                Toast.LENGTH_LONG
            ).show()
        }

    }

    override fun onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(this, getString(R.string.press_back_again_to_leave_the_app), Toast.LENGTH_LONG).show()
        }
        backPressedTime = System.currentTimeMillis()
    }


}