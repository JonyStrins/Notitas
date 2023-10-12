package com.example.notitasapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notitasapp.model.NotasTareas
import com.example.notitasapp.ui.components.NotasTareasViewModel
import com.example.notitasapp.ui.views.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasTareasApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { NotasTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
            val notasTareasViewModel: NotasTareasViewModel =
                viewModel(factory = NotasTareasViewModel.Factory)

            HomeScreen(
                notasTareasUiState = notasTareasViewModel.notasTareasUiState ,
                notasTareasViewModel::getNotasTareas)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "Notas Tareas",
                style = MaterialTheme.typography.headlineSmall
            )
        },
        modifier = modifier
    )
}