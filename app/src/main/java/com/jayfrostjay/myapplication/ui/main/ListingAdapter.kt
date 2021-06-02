package com.jayfrostjay.myapplication.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jayfrostjay.myapplication.data.Playlist
import com.jayfrostjay.myapplication.databinding.PlaylistListingBinding

class ListingAdapter(var list: List<Playlist>?): RecyclerView.Adapter<ListingAdapter.ListingViewHolder>() {

    var onClick: ((Playlist) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val view = PlaylistListingBinding.inflate(LayoutInflater.from(parent.context))
        return ListingViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        list?.get(position)?.let{ item ->
            holder.apply {
                Glide.with(view.root).load(item.thumbnailUrl).into(image)
                title.text = "Title: ${item.title}"
                description.text = "Description: ${item.description}"
                presenter.text = "Presenter: ${item.presenterName}"
                duration.text = "Duration: ${item.videoDuration.toString()}"

                card.setOnClickListener {
                    onClick?.invoke(item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class ListingViewHolder(v: PlaylistListingBinding): RecyclerView.ViewHolder(v.root) {
        val view = v
        val card = v.card
        val image = v.image
        val title = v.title
        val description = v.description
        val presenter = v.presenter
        val duration = v.duration
    }
}