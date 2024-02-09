package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private var counter : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.countBtn.setOnClickListener{
            binding.counterText.text = counter++.toString()
        }

        binding.downloadBtn.setOnClickListener{

            CoroutineScope(Dispatchers.IO).launch {
                downloadBigFileFromNet()
            }

        }

    }

    private fun downloadBigFileFromNet() {
        for(i in 1 .. 100000){
            Log.i("TAGY", "Downloading $i in ${Thread.currentThread().name}")
        }
    }
}