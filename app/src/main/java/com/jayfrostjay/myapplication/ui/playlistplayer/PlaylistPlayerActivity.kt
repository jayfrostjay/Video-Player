package com.jayfrostjay.myapplication.ui.playlistplayer

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.jayfrostjay.myapplication.databinding.PlaylistListingBinding

class PlaylistPlayerActivity: AppCompatActivity() {

    private lateinit var binding: PlaylistListingBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = PlaylistListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView(){

    }

    companion object {
        const val KEY_VID_URL = "vidURL"
    }
}