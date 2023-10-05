package com.example.notitasapp.ui.views


import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notitasapp.ui.components.BottomAppBarNotasTareasPreview
import java.nio.file.WatchEvent


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AddScreen() {
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { newText -> title = newText },
                label = { Text(text = "Titulo Nota") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(480.dp),
                value = body,
                onValueChange = { newText -> body = newText },
                label = { Text(text = "Descripcion") },
                maxLines = 50,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
//            Spacer(modifier = Modifier.height(20.dp))
        }
        Box (
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ){
            BottomAppBarNotasTareasPreview()
        }
    }
}