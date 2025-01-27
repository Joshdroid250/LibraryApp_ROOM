package com.example.libraryapproom.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "LibrosModels")
data class LibrosModels(
    @PrimaryKey(autoGenerate = true)
    val ID:Int = 0,
    @ColumnInfo(name = "nombreLibro")
    val nombreLibro: String,
    @ColumnInfo(name = "imagen")
    val Autor: String,
    @ColumnInfo(name = "genero")
    val genero:String,
    @ColumnInfo(name = "Paginas")
    val Paginas:String,
): Parcelable
