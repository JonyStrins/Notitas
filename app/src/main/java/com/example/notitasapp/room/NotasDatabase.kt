package com.example.notitasapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notitasapp.models.Notas

@Database(
    entities = [Notas::class],
    version = 1,
    exportSchema = false
)
abstract class NotasDatabase: RoomDatabase(){
    abstract fun notasDao(): NotasDatabaseDao
}