package com.example.estudio3.interfaces

import com.example.estudio3.classes.conApi.ListaALLamar
import com.example.estudio3.classes.conApi.ListaNaves
import com.example.estudio3.classes.conApi.ListaPlanetas
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceApi {
    @GET("people") // <- Nombre de lasendpoints
    suspend fun  obtenerPersonajes(): Response<ListaALLamar>


    // MAS ENDPOINTS
    @GET("planets")
    suspend fun  obtenerPlanetas(): Response<ListaPlanetas>


    @GET("starships")
    suspend fun  obtenerNaves(): Response<ListaNaves>




}