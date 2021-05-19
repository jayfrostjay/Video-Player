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
    }

    private initView(){
        
    }
}