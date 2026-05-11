package com.example.estudio3.apiFuncional.API

import com.example.estudio3.apiFuncional.classes.Naves
import com.example.estudio3.apiFuncional.classes.Personajes
import com.example.estudio3.apiFuncional.classes.Planetas
import com.example.estudio3.apiFuncional.retrofit.RetrofitClient

class MetodosApi {
    private val service = RetrofitClient.servicio

    suspend fun obetenrListaNombres(): List<Personajes> {
        val response = service.obtenerPersonajes() // <- Instanciar el metodo
        // Gracias al Response de la interface, ahora estas funciones son válidas
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList() //
        } else {
            emptyList()
        }
    }


    // MDOFICIAR LA ISNTANCIA List<Planetas>
    suspend fun obetenrListaPlanetas(): List<Planetas> {
        val response = service.obtenerPlanetas()
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList()
        } else {
            emptyList()
        }
    }

    suspend fun obetenrListaNaves(): List<Naves> {
        val response = service.obtenerNaves()
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList()
        } else {
            emptyList()
        }
    }
}