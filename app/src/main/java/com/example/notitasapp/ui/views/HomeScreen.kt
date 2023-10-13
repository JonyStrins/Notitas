package com.example.notitasapp.ui.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notitasapp.R
import com.example.notitasapp.models.NotasTareas
import com.example.notitasapp.ui.components.NotasTareasUiState

@Composable
fun HomeScreen(
    notasTareasUiState: NotasTareasUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (notasTareasUiState){
        is NotasTareasUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())

        is NotasTareasUiState.Succes -> NotasGridScreen(notas = notasTareasUiState.Notas, modifier)

        is NotasTareasUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
        else -> {}
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = "Fallo al cargar", modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(text = "Intentar de nuevo")
        }
    }
}

@Composable
fun NotasGridScreen(notas: List<NotasTareas>, modifier: Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ){
        items(items = notas ){
            notas ->
            NoteCard1(note = notas,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f))
        }
    }
}
@Composable
fun NoteCard1(
    note: NotasTareas,
    modifier: Modifier = Modifier
) {
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
//        modifier = modifier
//            .clickable { onSelectedNote(note) }
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
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading"
    )
}
