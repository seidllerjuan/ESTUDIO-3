package com.example.estudio3.API

import com.example.estudio3.classes.conApi.Naves
import com.example.estudio3.classes.conApi.Personajes
import com.example.estudio3.classes.conApi.Planetas
import com.example.estudio3.retrofit.RetrofitClient

class MetodosApi {
    private val service = RetrofitClient.servicio

    suspend fun obetenrListaNombres(): List<Personajes> {
        val response = service.obtenerPersonajes() // <- Instanciar el metodo
        // Gracias al Response de la interface, ahora estas funciones son válidas
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList() //
        } else {
            emptyList() // [cite: 44]
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