package com.example.android_pfti

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private var list: LocationList) :
    RecyclerView.Adapter<ListAdapter.ListAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListAdapterVH {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_rv, parent, false)
        return ListAdapterVH(itemView)
    }

    override fun onBindViewHolder(holder: ListAdapterVH, position: Int) {
        holder.lanTextView?.text = list.arrayOfMarkers[position].toString()
    }

    override fun getItemCount() = list.arrayOfMarkers.size

    inner class ListAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var lanTextView: TextView? = null

        init {
            lanTextView = itemView.findViewById(R.id.lan)
        }
    }
}