package com.myrecipesapp.newrecipes.internetcheck

interface ConnectionListener {
    fun onNetworkConnection(isConnected :Boolean)
}