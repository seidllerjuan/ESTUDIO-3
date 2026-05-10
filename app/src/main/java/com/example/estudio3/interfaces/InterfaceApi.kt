package com.example.estudio3.interfaces

import com.example.estudio3.classes.conApi.ListaALLamar
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceApi {
    @GET("people") // <- Nombre de lasendpoints
    suspend fun  obtenerPersonajes(): Response<ListaALLamar>
}