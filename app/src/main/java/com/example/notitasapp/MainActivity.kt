package com.example.notitasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notitasapp.ui.MainDestination
import com.example.notitasapp.ui.theme.NotitasAppTheme
import com.example.notitasapp.ui.views.AddScreen
import com.example.notitasapp.ui.views.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotitasAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = MainDestination.HomeScreen.route) {
                    composable(MainDestination.HomeScreen.route) {
                        HomeScreen(onNavigate = { screen ->
                            navigate(navHostController = navController, destination = screen)
                        })
                    }
                    composable(MainDestination.AddScreen.route) {
                        AddScreen()
                    }
                }
            }
        }
    }

    private fun navigate(navHostController: NavHostController, destination: MainDestination){
        navHostController.navigate(destination.route){
            //guarda el estado de la pantalla
            popUpTo(navHostController.graph.findStartDestination().id){
                saveState = true
            }
            //una pantalla solo se ejecute una vez, o sea que una pantalla solo tenga una instancia
            launchSingleTop = true
        }
    }
}

