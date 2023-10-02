package com.example.notitasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                        HomeScreen(onNavigate = {screen ->
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

