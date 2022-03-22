package com.jayfrostjay.myapplication.ui.playlistplayer

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.jayfrostjay.myapplication.databinding.ActivityPlayerBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class PlaylistPlayerActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding
    private lateinit var viewModel: PlaylistPlayerViewModel
    private lateinit var videoPlayer: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        viewModel = ViewModelProvider(this, PlaylistPlayerViewModel.Factory()).get(PlaylistPlayerViewModel::class.java)

        if(savedInstanceState == null){
            initObservers()
            initView()
            viewModel.loadVideoUrl(intent.getStringExtra(KEY_VID_URL) ?: "")
        }
    }

    override fun onResume() {
        super.onResume()
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStop() {
        super.onStop()
        videoPlayer.stop()
    }

    private fun initView(){
        videoPlayer = SimpleExoPlayer.Builder(this).build()
        binding.player.player = videoPlayer
    }

    private fun initObservers(){
        viewModel.videoUrl.observe(this, Observer { url ->
            val mediaItem: MediaItem = MediaItem.fromUri(url)
            videoPlayer.apply {
                setMediaItem(mediaItem)
                prepare()
                play()
                binding.player.visibility = View.VISIBLE
            }
        })
    }

    companion object {
        const val KEY_VID_URL = "vidURL"
    }
}