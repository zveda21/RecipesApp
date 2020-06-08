package com.myrecipesapp.newrecipes.internetcheck


import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.myrecipesapp.newrecipes.R

open class App : AppCompatActivity(), ConnectionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(InternetReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }
    private var snackbar: Snackbar? = null

    private fun showMessage(isConnected: Boolean) {

        if (!isConnected) {
            val message = " Check the internet connection!"
            snackbar = Snackbar.make(findViewById(R.id.mainLayout), message, Snackbar.LENGTH_LONG)
            snackbar?.duration = Snackbar.LENGTH_INDEFINITE
            snackbar?.show()
        } else snackbar?.dismiss()
    }

    override fun onNetworkConnection(isConnected: Boolean) {
        showMessage(isConnected)
    }

    override fun onResume() {
        super.onResume()
        InternetReceiver.connectionListener = this
    }
}