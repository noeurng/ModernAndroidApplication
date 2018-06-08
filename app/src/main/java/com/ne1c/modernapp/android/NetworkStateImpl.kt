package com.ne1c.modernapp.android

import android.net.ConnectivityManager
import com.ne1c.modernapp.domain.NetworkState

class NetworkStateImpl(private val connectivityManager: ConnectivityManager) : NetworkState {
    override fun isConnected(): Boolean {
        return connectivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false
    }
}