package com.example.radiusfacilities.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService


class NetWorkUtils {
    companion object{
        fun isInternetAvailable(context: Context): Boolean {
            val connectivityManager =
                getSystemService(context, ConnectivityManager::class.java)
            return connectivityManager?.let {
                val network = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    it.activeNetwork
                } else {
                    Toast.makeText(context, "Please turn on your internet!", Toast.LENGTH_LONG)
                }
                val networkCapabilities = it.getNetworkCapabilities(network as Network?)
                networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    ?: false
            } ?: false
        }
    }
}