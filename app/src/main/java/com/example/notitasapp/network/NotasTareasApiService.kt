package com.example.notitasapp.network

import com.example.notitasapp.models.NotasTareas
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://ae18-187-251-133-194.ngrok-free.app"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(
        Json.asConverterFactory("application/json".toMediaType())
    )
    .baseUrl(BASE_URL)
    .build()
interface NotasTareasApiService {

    /**
     * Aqui se pondra solo como ejemplo notaTarea hasta que se tenga
     * bien definida la funcion HTTP
     */
    @GET("api/NotasTareas")
    suspend fun getNotasTareas(): List<NotasTareas>
}