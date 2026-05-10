package com.example.estudio3.classes.conApi

import kotlinx.serialization.Serializable

@Serializable
data class ListaALLamar(
    val message: String,
    val results: List<Personajes>
)

@Serializable
data class Personajes(
    val uid: String,
    val name: String,
    val url: String
)

