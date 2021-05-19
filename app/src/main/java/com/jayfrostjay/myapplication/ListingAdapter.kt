package com.jayfrostjay.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jayfrostjay.myapplication.data.Playlist

class ListingAdapter(private val list: List<Playlist>?): RecyclerView.Adapter<ListingAdapter.ListingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.playlist_listing, parent, false)
        return ListingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        list?.get(position)?.let{
            holder.apply {
                title.text = it.title
                description.text = it.description
                presenter.text = it.presenterName
                duration.text = it.videoDuration.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class ListingViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val image = v.findViewById<ImageView>(R.id.image)
        val title = v.findViewById<TextView>(R.id.title)
        val description = v.findViewById<TextView>(R.id.description)
        val presenter = v.findViewById<TextView>(R.id.presenter)
        val duration = v.findViewById<TextView>(R.id.duration)
    }
}