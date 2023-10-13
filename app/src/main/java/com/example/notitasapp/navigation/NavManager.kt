package com.example.notitasapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notitasapp.ui.views.AddScreen
import com.example.notitasapp.ui.views.HomeScreen
import com.example.notitasapp.viewmodels.NotasViewModel

@Composable
fun NavManager(viewModel: NotasViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio"){
        composable("inicio"){
            //HomeScreen(navController, viewModel)
        }
        composable("agregar"){
            //AddScreen(navController, viewModel)
        }
        composable("editar/{id}", arguments = listOf(
            navArgument("id"){type = NavType.IntType}
        )){
         /*
         Agregar Otra Pagina para editar y mandar los parametros
          */
        }
    }
}