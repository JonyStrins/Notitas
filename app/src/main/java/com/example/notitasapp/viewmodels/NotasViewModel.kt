package com.example.notitasapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notitasapp.models.Notas
import com.example.notitasapp.room.NotasDatabaseDao
import com.example.notitasapp.states.NotasState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class NotasViewModel(
    private val dao: NotasDatabaseDao
): ViewModel() {
    var state by mutableStateOf(NotasState())
        private set

    init {
        viewModelScope.launch {
            dao.obtenerNotas().collectLatest {
                state = state.copy(
                    listaNotas = it
                )
            }
        }
    }

    fun agregarNota(nota: Notas) = viewModelScope.launch {
        dao.agregarNota(nota = nota)
    }

    fun editarNota(nota: Notas) = viewModelScope.launch {
        dao.editarNota(nota = nota)
    }

    fun eliminarNota(nota: Notas) = viewModelScope.launch {
        dao.eliminarNota(nota = nota)
    }
}