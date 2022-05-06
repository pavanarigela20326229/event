package com.example.eventsdemo.ui

import Event
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eventsdemo.R
import com.example.eventsdemo.databinding.ItemEventBinding

class EventAdapter(var eventClick: (Event) -> Unit) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {
    private var eventList = mutableListOf<Event>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = eventList[position]
        val imageUrl = if (event.images.isNotEmpty()) event.images[0].url else ""
        holder.itemEventBinding.tvEventName.text = event.name
        Glide.with(holder.itemEventBinding.ivEvent.context).load(imageUrl)
            .placeholder(R.drawable.place_holder)
            .into(holder.itemEventBinding.ivEvent)
        holder.itemEventBinding.root.setOnClickListener {
            eventClick(event)
        }


    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUpData(list: MutableList<Event>) {
        eventList = list
        notifyDataSetChanged()

    }


    class ViewHolder(var itemEventBinding: ItemEventBinding) :
        RecyclerView.ViewHolder(itemEventBinding.root)
}