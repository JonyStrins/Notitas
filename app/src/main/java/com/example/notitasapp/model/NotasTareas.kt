package com.example.notitasapp.model

import kotlinx.serialization.Serializable
import java.sql.Date

@Serializable
data class NotasTareas(
    val id: Int,
    val titulo: String,
    val contenido: String,
    val estatus: Int,
    val tipo: Int,
    val fecha: Date,
    val fechaModi: Date,
    val fechaCum: Date
)