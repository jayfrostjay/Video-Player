package com.jayfrostjay.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jayfrostjay.myapplication.api.ApiService
import com.jayfrostjay.myapplication.api.Repository
import com.jayfrostjay.myapplication.api.Service
import com.jayfrostjay.myapplication.data.Playlist
import com.jayfrostjay.myapplication.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val service: Service = ApiService().createService(Service::class.java)
    private val repository: Repository = Repository(service)
    private val list = mutableListOf<Playlist>()
    private var listAdapter: ListingAdapter = ListingAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("TESTING: initView")

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        callList()
    }


    private fun initView(){
        binding.list.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = this@MainActivity.listAdapter
        }
    }

    @SuppressLint("LogNotTimber")
    private fun callList(){
        repository.getPlaylist {
            it?.let{ list ->
                this@MainActivity.list.apply {
                    clear()
                    addAll(list)
                }
                listAdapter.notifyDataSetChanged()
            }
        }
    }
}