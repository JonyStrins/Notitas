package com.example.notitasapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.notitasapp.ui.theme.NotitasAppTheme

@Composable
private fun BottomAppBarNotasTareas(){
    BottomAppBar(
        actions = {
            IconButton(onClick = {}) {
                Icon(
                   imageVector = Icons.Outlined.PlayArrow,
                    contentDescription = "Multimedia"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Eliminar"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Fecha"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        },
        containerColor = Color(0xBEA8F5C7)
    )
}

@Composable
fun fakeBottomAppBarNotasTareas(){
    NotitasAppTheme{
        BottomAppBarNotasTareas()
    }
}

@Preview
@Composable
fun BottomAppBarNotasTareasPreview(){
    fakeBottomAppBarNotasTareas()
}