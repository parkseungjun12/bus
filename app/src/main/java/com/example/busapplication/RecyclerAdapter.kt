package com.example.busapplication

import android.util.Log

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class RecyclerAdapter(items: ArrayList<BusModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val items = items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val busNumber: TextView = itemView.findViewById(R.id.tv_bus_number)
        val remainTime: TextView = itemView.findViewById(R.id.tv_remain_time)
        val remainBusStop: TextView = itemView.findViewById(R.id.tv_remain_bus_stop)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context.applicationContext).inflate(R.layout.detail_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = items[position]
        holder.busNumber.text = items.routenoString
        holder.remainTime.text = items.arrprevstationcntString
        holder.remainBusStop.text = items.arrtimeString
    }
}