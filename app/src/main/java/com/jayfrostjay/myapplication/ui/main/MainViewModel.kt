package com.jayfrostjay.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jayfrostjay.myapplication.api.ApiService
import com.jayfrostjay.myapplication.api.Repository
import com.jayfrostjay.myapplication.api.Service
import com.jayfrostjay.myapplication.data.Playlist

class MainViewModel: ViewModel() {

    private val service: Service = ApiService().createService(Service::class.java)
    private val repository: Repository = Repository(service)

    private val _list = MutableLiveData<List<Playlist>>()
    val list: LiveData<List<Playlist>> = _list

    fun getList(){
        repository.getPlaylist {
            it?.let{
                _list.postValue(it)
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory: ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel() as T
        }
    }
}