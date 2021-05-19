package com.jayfrostjay.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jayfrostjay.myapplication.api.ApiService
import com.jayfrostjay.myapplication.api.Repository
import com.jayfrostjay.myapplication.api.Service
import com.jayfrostjay.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val service: Service = ApiService().createService(Service::class.java)
    private val repository: Repository = Repository(service)
    private val listAdapter

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

        }
    }

    private fun callList(){
        repository.getPlaylist {
            it?.let{

            }
        }
    }
}