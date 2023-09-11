package com.example.notitasapp.network

import com.example.notitasapp.model.NotasTareas
import retrofit2.http.GET

interface NotasTareasApiService {

    /**
     * Aqui se pondra solo como ejemplo notaTarea hasta que se tenga
     * bien definida la funcion HTTP
     */
    @GET("notatarea")
    suspend fun getNotasTareas(): List<NotasTareas>
}