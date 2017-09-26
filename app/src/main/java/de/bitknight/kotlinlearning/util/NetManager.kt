package de.bitknight.kotlinlearning.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by dsemprich on 26.09.17.
 */
class NetManager(private var applicationContext: Context) {
    private var status: Boolean? = false

    val isConnectedToInternet: Boolean?
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val ni = conManager.activeNetworkInfo
            return ni != null && ni.isConnected
        }
}