package com.example.notitasapp.data

import com.example.notitasapp.models.NotasTareas
import com.example.notitasapp.network.NotasTareasApiService

interface NotasTareasRepository {
    suspend fun getNotasTareas(): List<NotasTareas>
}

class NetworkNotasTareasRepository(
    private val notasTareasApiService: NotasTareasApiService
): NotasTareasRepository{
    override suspend fun getNotasTareas(): List<NotasTareas> = notasTareasApiService.getNotasTareas()
}