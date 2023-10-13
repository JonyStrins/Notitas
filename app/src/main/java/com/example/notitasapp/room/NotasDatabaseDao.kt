package com.example.notitasapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notitasapp.models.Notas
import kotlinx.coroutines.flow.Flow

@Dao
interface NotasDatabaseDao {

    @Query("SELECT * FROM notas")
    fun obtenerNotas(): Flow<List<Notas>>

    @Query("SELECT * FROM notas WHERE id = :id")
    fun obtenerNota(id: Int): Flow<Notas>

    @Insert
    suspend fun agregarNota(nota: Notas)

    @Update
    suspend fun editarNota(nota: Notas)

    @Delete
    suspend fun eliminarNota(nota: Notas)

}