package com.example.libraryapproom.bd.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.libraryapproom.bd.entidades.LibrosModels
import com.example.libraryapproom.bd.entidades.PrestamosEntity

interface MainDataBaseProvider {
    fun librosDao(): LibrosDao
    fun prestamosDao(): PrestamosDao
}

@Database(
    entities = [LibrosModels::class, PrestamosEntity::class],
    version = 3
)
abstract class MainBaseDatos : RoomDatabase(),
    MainDataBaseProvider {
    abstract override fun librosDao(): LibrosDao
    abstract override fun prestamosDao(): PrestamosDao
    companion object {
        @Volatile
        private var INSTANCE: MainBaseDatos? = null

        fun getDataBase(context: Context): MainBaseDatos {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainBaseDatos::class.java,
                        "main_db"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}