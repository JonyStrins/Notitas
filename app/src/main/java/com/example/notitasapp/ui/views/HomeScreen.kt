package com.example.notitasapp.ui.views


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.notitasapp.model.NotasTareas
import com.example.notitasapp.ui.MainDestination
import com.example.notitasapp.ui.components.NotasTareasUiState
import com.example.notitasapp.ui.components.NoteList
import com.example.notitasapp.ui.theme.NotitasAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (MainDestination)->Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {Text("Agregar")},
                onClick = { onNavigate(MainDestination.AddScreen)},
                containerColor = Color(0xFFA1D0F0),
                icon = {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add"
                )
            } )
        }
    ) {
        //solo se crea para mostrar un ejemplo de como quedaria
        val notes = listOf(
            NotasTareas(id = 1, titulo = "Primera nota", contenido = "esta es la primera nota de la app\nsiguiente linea ", estatus = 1, tipo = 1, ),
            NotasTareas(id = 1, titulo = "Segunda nota", contenido = "Una segunda nota para la aplicacion\nde la materia de movil ", estatus = 1, tipo = 1,),
            NotasTareas(id = 1, titulo = "Tercera nota", contenido = "I was born with the wrong sign\nIn the wrong house", estatus = 1, tipo = 1,),
            NotasTareas(id = 1, titulo = "Cuarta nota", contenido = "With the wrong ascendancy\nI took the wrong road", estatus = 1, tipo = 1,),
            NotasTareas(id = 1, titulo = "Quinta nota", contenido = "That led to the wrong tendencies\nI was in the wrong place at the wrong time", estatus = 1, tipo = 1,),
        )
        //en esta parte es donde se manda a llamar el componente de la lista de las notas
        NoteList(modifier = Modifier.padding(it), notes = notes , onSelectedNote = {})

    }
}
@Composable
fun FakeHomeScreen(){
    NotitasAppTheme{
        HomeScreen(onNavigate = {})
    }
}
@Preview
@Composable
fun HomeScreenView(){
    FakeHomeScreen()
}

