package com.example.notitasapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notitasapp.model.NotasTareas
import com.example.notitasapp.ui.theme.NotitasAppTheme


@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: NotasTareas,
    onSelectedNote: (note: NotasTareas) -> Unit
    ){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xE4A8F5C7),
            contentColor = Color(0xFF000000)
        ),
        modifier = modifier.clickable{onSelectedNote(note)}
            .border(
                border = BorderStroke(2.dp, Color(0xE4A8F5C7)),
                shape = CutCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = note.titulo, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = note.contenido, maxLines = 3, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun fakeNoteCard(){
    NotitasAppTheme{
        NoteCard(
            note = NotasTareas(
                id = 1,
                titulo = "primera nota",
                contenido = "esta es la primera nota de la app\nsiguiente linea ",
                estatus = 1,
                tipo = 1,
//                fecha = Date(),
//                fechaModi = Date1(),
//                fechaCum = Date1(),
            ), onSelectedNote = {})
    }
}
@Preview
@Composable
fun NoteCardPreview(){
    fakeNoteCard()
}