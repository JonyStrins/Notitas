package com.example.notitasapp.model

import kotlinx.serialization.Serializable
import java.sql.Date

@Serializable
data class NotasTareas(
    val id: ULong,
    val titulo: String,
    val contenido: String?,
    val estatus: Int,
    val tipo: Int,
    val fecha: String,
    val fechaModi: String,
    val fechaCum: String?
)