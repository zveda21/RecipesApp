package com.myrecipesapp.newrecipes.internetcheck

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager


open class InternetReceiver: BroadcastReceiver() {

    companion object{
        var connectionListener : ConnectionListener? = null

    }
    override fun onReceive(context: Context, intent: Intent) {

        if (connectionListener != null) {
            connectionListener!!.onNetworkConnection(isConnected(context))
        }

    }
    private fun isConnected(context: Context?):Boolean{
        val cm = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork!=null && activeNetwork.isConnectedOrConnecting
    }

}