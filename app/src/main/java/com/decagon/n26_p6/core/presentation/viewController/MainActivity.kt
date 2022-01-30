package com.decagon.n26_p6.core.presentation.viewController

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.decagon.n26_p6.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}