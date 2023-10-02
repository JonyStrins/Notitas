package com.example.notitasapp.ui

sealed class MainDestination(val route: String){
    object HomeScreen: MainDestination(route = "home")
    object AddScreen: MainDestination(route = "add")
}
