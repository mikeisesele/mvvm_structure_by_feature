package com.decagon.n26_p6.app

import android.app.Application
import com.decagon.n26_p6.common.utils.NetworkLiveData
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        NetworkLiveData.init(this)
    }
}