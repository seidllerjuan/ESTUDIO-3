package com.example.estudio3.API

import com.example.estudio3.classes.conApi.Personajes
import com.example.estudio3.retrofit.RetrofitClient

class MetodosApi {
    private val service = RetrofitClient.servicio

    suspend fun obetenrListaNombres(): List<Personajes> {
        val response = service.obtenerPersonajes()
        // Gracias al Response de la interface, ahora estas funciones son válidas
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList() //
        } else {
            emptyList() // [cite: 44]
        }
    }
}