package com.decagon.n26_p6.features.jokes.presentation.viewController

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.decagon.n26_p6.R
import com.decagon.n26_p6.common.utils.NetworkLiveData
import com.decagon.n26_p6.common.utils.Resource
import com.decagon.n26_p6.common.utils.toast
import com.decagon.n26_p6.databinding.ActivityJokesBinding
import com.decagon.n26_p6.features.jokes.presentation.viewModel.JokesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class JokesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityJokesBinding
    private val viewModel : JokesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokesBinding.inflate(layoutInflater)
    }


    override fun onResume() {
        super.onResume()

        if(NetworkLiveData.isNetworkAvailable()){
            viewModel.getJokes()
            viewModel.getProgrammingJokes()
        }else{
            toast(this, "No Internet Connection")
        }

        viewModel.jokesData.observe(this) {

            when (it) {
                is Resource.Loading -> {
                    toast(this, "Loading")
                }

                is Resource.Success -> {
                    toast(this, "success")
                }

                is Resource.Error -> {
                    toast(this, "an error occurred")
                }
            }
        }
    }
}