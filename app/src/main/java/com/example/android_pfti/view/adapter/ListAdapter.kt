package com.example.android_pfti.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_pfti.model.repo.LocationList
import com.example.android_pfti.R

class ListAdapter(private var list: LocationList) :
    RecyclerView.Adapter<ListAdapter.ListAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterVH {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_rv, parent, false)
        return ListAdapterVH(itemView)
    }

    override fun onBindViewHolder(holder: ListAdapterVH, position: Int) {
        holder.latlngTextView?.text = LocationList.arrayOfMarkers[position].first.toString()
        holder.nameTextView?.text = LocationList.arrayOfMarkers[position].second.toString()
    }

    override fun getItemCount() = LocationList.arrayOfMarkers.size

    inner class ListAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var latlngTextView: TextView? = null
        var nameTextView: TextView? = null
        init {
            latlngTextView = itemView.findViewById(R.id.latlng_rv)
            nameTextView = itemView.findViewById(R.id.name_rv)
        }
    }
}