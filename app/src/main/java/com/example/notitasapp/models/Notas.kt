package com.example.notitasapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notas")
data class Notas(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("titulo")
    val titulo: String,
    @ColumnInfo("contenido")
    val contenido: String,
    @ColumnInfo("estatus")
    val estatus: Int,
    @ColumnInfo("tipo")
    val tipo: Int,
    @ColumnInfo("fecha")
    val fecha: String,
    @ColumnInfo("fechaModi")
    val fechaModi: String,
    @ColumnInfo("fechaCum")
    val fechaCum: String
)
