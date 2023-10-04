package com.example.notitasapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notitasapp.model.NotasTareas
import com.example.notitasapp.ui.theme.NotitasAppTheme

@Composable
fun NoteList(
    modifier: Modifier = Modifier,
    notes: List<NotasTareas>,
    onSelectedNote: (note: NotasTareas) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 250.dp),
        modifier = modifier.fillMaxSize()
    ) {

        items(items = notes) { note ->
            NoteCard(
                modifier = Modifier
                    .padding(10.dp)
                    .height(125.dp)
                    .width(150.dp),
                note = note,
                onSelectedNote = onSelectedNote
            )
            Spacer(modifier = Modifier.height(36.dp))
        }
    }
}

@Composable
fun FakeNoteList(){
    NotitasAppTheme{
//        val notes = listOf(
//            NotasTareas(id = 1, titulo = "Primera nota", contenido = "esta es la primera nota de la app\nsiguiente linea ", estatus = 1, tipo = 1,),
//            NotasTareas(id = 1, titulo = "Segunda nota", contenido = "Una segunda nota para la aplicacion\nde la materia de movil ", estatus = 1, tipo = 1,),
//            NotasTareas(id = 1, titulo = "Tercera nota", contenido = "I was born with the wrong sign\nIn the wrong house", estatus = 1, tipo = 1,),
//            NotasTareas(id = 1, titulo = "Cuarta nota", contenido = "With the wrong ascendancy\nI took the wrong road", estatus = 1, tipo = 1,),
//            NotasTareas(id = 1, titulo = "Quinta nota", contenido = "That led to the wrong tendencies\nI was in the wrong place at the wrong time", estatus = 1, tipo = 1,),
//            )
//        NoteList(notes = notes, onSelectedNote = {})
    }
}

@Preview
@Composable
fun NoteListPreview(){
    FakeNoteList()
}