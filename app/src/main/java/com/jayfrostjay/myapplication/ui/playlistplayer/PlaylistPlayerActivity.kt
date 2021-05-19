package com.jayfrostjay.myapplication.ui.playlistplayer

import android.R
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.jayfrostjay.myapplication.databinding.ActivityPlayerBinding


class PlaylistPlayerActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding
    private var url: String = ""

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        url = intent.getStringExtra(KEY_VID_URL) ?: ""
        Log.d("TESTING", url.toString())

        initView()
    }

    private fun initView(){

        val player = SimpleExoPlayer.Builder(this).build()
        binding.player.player = player

        val mediaItem: MediaItem = MediaItem.fromUri(url)
        player.setMediaItem(mediaItem)

        player.prepare()
    }

    companion object {
        const val KEY_VID_URL = "vidURL"
    }
}