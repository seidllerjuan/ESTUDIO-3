package com.example.estudio3.apiFuncional.classes

import kotlinx.serialization.Serializable


//ESTAS DATACLASES SON LLAMDAS EN INTERFACE
@Serializable
data class ListaALLamar(
    val message: String,
    val results: List<Personajes>
)

data class ListaPlanetas(
    val message: String,
    val results: List<Planetas>
)

data class ListaNaves(
    val message: String,
    val results: List<Naves>
)



//Estas data clases son llamadas en Metodos api y starwarsviewmodel, igual en productviewmodel
@Serializable
data class Personajes(
    val uid: String,
    val name: String,
    val url: String,
    // Agregamos lo que vimos en el JSON
    val gender: String? = null,
    val eye_color: String? = null
)

@Serializable
data class Planetas(
    val uid: String,
    val name: String,
    val url: String,
    // Agregamos los de planetas
    val climate: String? = null,
    val terrain: String? = null
)

@Serializable
data class Naves(
    val uid: String,
    val name: String,
    val url: String,
    // Agregamos los de naves
    val model: String? = null,
    val cost_in_credits: String? = null
)
