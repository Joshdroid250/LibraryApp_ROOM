package com.example.libraryapproom.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.libraryapproom.bd.dao.MainBaseDatos
import com.example.libraryapproom.bd.entidades.PrestamosEntity
import com.example.libraryapproom.bd.repository.PrestamosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PrestamoViewModel(application: Application): AndroidViewModel(application) {
    val lista : LiveData<List<PrestamosEntity>>
    private val repository: PrestamosRepository

    init {
        val prestamosDao =
            MainBaseDatos.getDataBase(application).prestamosDao()
        repository = PrestamosRepository(prestamosDao)
        lista = repository.listado
    }

        fun agregarPrestamo(prestamo: PrestamosEntity){
            viewModelScope.launch(Dispatchers.IO){
                repository.addPrestamo(prestamo)
            }
        }

        fun actualizarPrestamo(prestamo: PrestamosEntity){
            viewModelScope.launch(Dispatchers.IO){
                repository.updatePrestamo(prestamo)
            }
        }

        fun eliminarPrestamo(prestamo: PrestamosEntity){
            viewModelScope.launch(Dispatchers.IO){
                repository.deleteGenero(prestamo)
            }
        }

        fun eliminarTodo(){
            viewModelScope.launch(Dispatchers.IO){
                repository.deleteAll()
            }
        }


}