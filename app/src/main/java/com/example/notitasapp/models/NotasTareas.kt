package com.example.notitasapp.models

import kotlinx.serialization.Serializable

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