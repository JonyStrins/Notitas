package com.example.notitasapp.ui.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notitasapp.NotitasApplication
import com.example.notitasapp.data.NotasTareasRepository
import com.example.notitasapp.models.NotasTareas
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface NotasTareasUiState{
    data class Succes(val Notas: List<NotasTareas>) : NotasTareasUiState
    object Error : NotasTareasUiState
    object Loading : NotasTareasUiState
}
class NotasTareasViewModel(private val notasTareasRepository: NotasTareasRepository) : ViewModel(){
    var notasTareasUiState: NotasTareasUiState by mutableStateOf(NotasTareasUiState.Loading)
        private set

    init {
        getNotasTareas()
    }

    fun getNotasTareas(){
        viewModelScope.launch {
            notasTareasUiState = try {
                val listResult = notasTareasRepository.getNotasTareas()
                NotasTareasUiState.Succes(
                    listResult
                )
            }catch (e: IOException){
                NotasTareasUiState.Error
            }
//            try {
//                val listResult = notasTareasRepository.getNotasTareas()
////                listResult.forEach{Log.}
//            }catch (e: IOException){
//
//            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NotitasApplication)
                val notasTareasRepository = application.container.notasTareasRepository
                NotasTareasViewModel(notasTareasRepository = notasTareasRepository)
            }
        }
    }
}