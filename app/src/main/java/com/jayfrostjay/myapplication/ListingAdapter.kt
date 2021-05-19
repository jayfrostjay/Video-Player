package com.jayfrostjay.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jayfrostjay.myapplication.data.Playlist

class ListingAdapter(private val list: List<Playlist>): RecyclerView.Adapter<ListingAdapter.ListingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.playlist_listing, parent, false)
        return ListingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListingViewHolder(v: View): RecyclerView.ViewHolder(v) {

    }
}