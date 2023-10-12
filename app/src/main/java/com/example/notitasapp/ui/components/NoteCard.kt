package com.example.notitasapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notitasapp.model.NotasTareas
import com.example.notitasapp.ui.theme.NotitasAppTheme


@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: NotasTareas,
    onSelectedNote: (note: NotasTareas) -> Unit
    ){
    Card(
        shape = RoundedCornerShape(20.dp),
        //border = BorderStroke(1.dp, Color(0x8F00F061)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 15.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xCEBDF5D4),
            contentColor = Color(0xFF000000)
        ),
        modifier = modifier
            .clickable { onSelectedNote(note) }
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = note.titulo, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(6.dp))
            //Text(text = note.contenido, maxLines = 3, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(6.dp))
            Row (
                modifier = Modifier.padding(5.dp)
            ){
                Text(text = note.fecha, fontSize = 10.sp)
                Spacer(modifier = Modifier.width(195.dp))
                Text(text = note.fechaModi, fontSize = 10.sp)
            }
        }
    }
}

@Composable
fun fakeNoteCard(){
    NotitasAppTheme{
        NoteCard(
            note = NotasTareas(
                id = 1UL,
                titulo = "primera nota",
                contenido = "esta es la primera nota de la app\nsiguiente linea ",
                estatus = 1,
                tipo = 1,
                fecha = "05/10/2023",
                fechaModi = "06/10/2023",
                fechaCum = "07/10/2023",
            ), onSelectedNote = {})
    }
}
@Preview
@Composable
fun NoteCardPreview(){
    fakeNoteCard()
}