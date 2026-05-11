package com.example.estudio3.API

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.estudio3.classes.conApi.ListaNaves
import com.example.estudio3.classes.conApi.Naves
import com.example.estudio3.classes.conApi.Personajes
import com.example.estudio3.classes.conApi.Planetas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher


class StarwarsViewModel: ViewModel() {
    var listarPersonajes by mutableStateOf<List<Personajes>>(emptyList())
        private set

    var listarPlanetas by mutableStateOf<List<Planetas>>(emptyList())
        private set

    var listarNaves by mutableStateOf<List<Naves>>(emptyList())
        private set

    fun fetchPersonajes(){
        // Se ejecuta en un hilo secundario (IO) para no trabar la app [cite: 48, 49]

        viewModelScope.launch {
            val resultado = withContext(Dispatchers.IO){
                MetodosApi().obetenrListaNombres()
            }
            listarPersonajes = resultado

        }
    }

    fun fetchPlanetas(){
        // Se ejecuta en un hilo secundario (IO) para no trabar la app [cite: 48, 49]
        viewModelScope.launch {
            val resultado = withContext(Dispatchers.IO){
                MetodosApi().obetenrListaPlanetas()
            }
            listarPlanetas = resultado

        }
    }

    fun fetchNaves(){
        viewModelScope.launch {
            val resultado = withContext(Dispatchers.IO){
                MetodosApi().obetenrListaNaves()
            }
            listarNaves = resultado

        }
    }

}