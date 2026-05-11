package com.example.estudio3.apiFuncional.interfaces

import com.example.estudio3.apiFuncional.classes.ListaALLamar
import com.example.estudio3.apiFuncional.classes.ListaNaves
import com.example.estudio3.apiFuncional.classes.ListaPlanetas
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceApi {
    @GET("people") // <- Nombre de lasendpoints
    suspend fun obtenerPersonajes(): Response<ListaALLamar>


    // MAS ENDPOINTS
    @GET("planets")
    suspend fun obtenerPlanetas(): Response<ListaPlanetas>


    @GET("starships")
    suspend fun obtenerNaves(): Response<ListaNaves>

}