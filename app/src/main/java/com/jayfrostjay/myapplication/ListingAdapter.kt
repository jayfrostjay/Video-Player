package com.jayfrostjay.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
                Glide.with(holder.view).load(it.thumbnailUrl).into(image)
                title.text = "Title: ${it.title}"
                description.text = "Description: ${it.description}"
                presenter.text = "Presenter: ${it.presenterName}"
                duration.text = "Duration: ${it.videoDuration.toString()}"
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class ListingViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val view = v
        val card = v.findViewById<CardView>(R.id.card)
        val image = v.findViewById<ImageView>(R.id.image)
        val title = v.findViewById<TextView>(R.id.title)
        val description = v.findViewById<TextView>(R.id.description)
        val presenter = v.findViewById<TextView>(R.id.presenter)
        val duration = v.findViewById<TextView>(R.id.duration)
    }
}