package com.example.notitasapp.states

import com.example.notitasapp.models.Notas

data class NotasState(
    val listaNotas: List<Notas> = emptyList()
)
