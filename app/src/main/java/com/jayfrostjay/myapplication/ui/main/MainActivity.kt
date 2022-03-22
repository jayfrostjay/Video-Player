package com.jayfrostjay.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jayfrostjay.myapplication.databinding.ActivityMainBinding
import com.jayfrostjay.myapplication.ui.playlistplayer.PlaylistPlayerActivity
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var listAdapter: ListingAdapter = ListingAdapter(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(DebugTree())

        viewModel = ViewModelProvider(this, MainViewModel.Factory()).get(MainViewModel::class.java)

        if(savedInstanceState == null){
            initObservers()
            initView()
        }
    }

    private fun initView(){
        binding.loader.visibility = View.VISIBLE

        binding.list.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = this@MainActivity.listAdapter

            this@MainActivity.listAdapter.apply {
                onClick = {
                    val myIntent = Intent(this@MainActivity, PlaylistPlayerActivity::class.java).apply {
                        putExtra(PlaylistPlayerActivity.KEY_VID_URL, it.videoUrl)
                    }
                    this@MainActivity.startActivity(myIntent)
                }
            }
        }

        binding.swipe.setOnRefreshListener {
            viewModel.clearList()
            viewModel.getList()
        }

        viewModel.getList()
    }

    private fun initObservers(){
        viewModel.list.observe(this, Observer {
            binding.apply {
                loader.visibility = View.GONE
                swipe.isRefreshing = false
            }

            this@MainActivity.listAdapter.apply {
                list = it
                notifyDataSetChanged()
            }
        })
    }
}