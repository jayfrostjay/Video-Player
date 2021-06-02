package com.jayfrostjay.myapplication.ui.playlistplayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlaylistPlayerViewModel: ViewModel() {

    private var videoUrlData = ""
    private val _videoUrl = MutableLiveData<String>()
    val videoUrl: LiveData<String> = _videoUrl

    fun loadVideoUrl(url: String){
        videoUrlData = url

        _videoUrl.postValue(videoUrlData)
    }

    @Suppress("UNCHECKED_CAST")
    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PlaylistPlayerViewModel() as T
        }
    }
}