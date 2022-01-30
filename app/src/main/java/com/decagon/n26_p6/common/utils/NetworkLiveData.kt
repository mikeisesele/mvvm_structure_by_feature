package com.decagon.n26_p6.common.utils

    import android.app.Application
    import android.net.ConnectivityManager
    import android.content.Context
    import android.net.Network
    import android.net.NetworkCapabilities
    import android.net.NetworkRequest
    import androidx.lifecycle.LiveData

    object NetworkLiveData : LiveData<Boolean>() {

        override fun onActive() {
            super.onActive()
            getDetails()
        }

        private lateinit var application: Application
        private lateinit var networkRequest: NetworkRequest

        fun init(application: Application) {
            this.application = application
            networkRequest = NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build()
        }

        private fun getDetails() {
            val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            cm.registerNetworkCallback(networkRequest, object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    postValue(true)
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    postValue(false)
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    postValue(false)
                }
            })
        }

        fun isNetworkAvailable(): Boolean {
            val cm = application.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnected
        }

    }
