package com.example.estudio3.classes.productosYcategorias

data class ProductMofrl(
    val uid: String,
    val Nombre: String,
    val imagen: Int,
    val url: String = "",           // <-- IMPORTANTE EL = ""

    val gusto: Boolean = false,

    //COMO HAY DATOS COMUNALES LOS VALIDAMOS okokokok ya si no se muestran o no estan contemplados podemos validarlos
    // Datos específicos de Personajes
    val genero: String? = null,
    val colorOjos: String? = null,
    // Datos específicos de Planetas
    val clima: String? = null,
    val terreno: String? = null,
    // Datos específicos de Naves
    val modelo: String? = null,
    val costo: String? = null
)