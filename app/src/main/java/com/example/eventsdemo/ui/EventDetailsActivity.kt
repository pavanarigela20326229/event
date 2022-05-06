package com.example.eventsdemo.ui

import Event
import com.bumptech.glide.Glide
import com.example.eventsdemo.R
import com.example.eventsdemo.core.BaseActivity
import com.example.eventsdemo.databinding.ActivityEventDetailsBinding
import com.example.eventsdemo.utils.IConstants
import kotlinx.android.synthetic.main.common_toolbar.view.*
/**
 * this activity is used to show event details
 */
class EventDetailsActivity : BaseActivity<ActivityEventDetailsBinding>() {

    private var event: Event? = null
    override fun getLayout(): Int {
        return R.layout.activity_event_details
    }

    override fun initView() {
        if (intent.hasExtra(IConstants.EVENT)) {
            event = intent?.getParcelableExtra(IConstants.EVENT)
            setEventDetails()
        }
        setOnClickListeners()

    }

    private fun setOnClickListeners() {
        binding.eventDetailsToolbar.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setEventDetails() {
        binding.eventDetailsToolbar.tvTitle.text = event?.name
        val url = if (event?.images?.isNotEmpty() == true) event?.images!![0].url else ""
        Glide.with(this).load(url).placeholder(R.drawable.place_holder).into(binding.ivEvent)
        binding.tvEventType.text = "${getString(R.string.type)} : ${event?.type}"
    }
}