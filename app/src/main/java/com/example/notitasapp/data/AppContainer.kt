package com.example.notitasapp.data

import com.example.notitasapp.network.NotasTareasApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val notasTareasRepository: NotasTareasRepository
}
class DefaultAppContainer : AppContainer{
    private val baseUrl = "https://ae18-187-251-133-194.ngrok-free.app"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: NotasTareasApiService by lazy {
        retrofit.create(NotasTareasApiService::class.java)
    }

    override val notasTareasRepository: NotasTareasRepository by lazy {
        NetworkNotasTareasRepository(retrofitService)
    }
}