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

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        list?.get(position)?.let{ item ->
            holder.apply {
                this.onClick = this@ListingAdapter.onClick
                binData(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class ListingViewHolder(private val v: PlaylistListingBinding): RecyclerView.ViewHolder(v.root) {
        var onClick: ((Playlist) -> Unit)? = null
        fun binData(item: Playlist?){
            item ?: return
            Glide.with(v.root).load(item.thumbnailUrl).into(v.image)
            v.title.text = "Title: ${item.title}"
            v.description.text = "Description: ${item.description}"
            v.presenter.text = "Presenter: ${item.presenterName}"
            v.duration.text = "Duration: ${item.videoDuration.toString()}"
            v.card.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }
}