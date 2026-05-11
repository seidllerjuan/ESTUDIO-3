package com.example.estudio3.classes.productosYcategorias

import com.example.estudio3.API.StarwarsViewModel
import com.example.estudio3.R
import com.example.estudio3.classes.conApi.Naves
import com.example.estudio3.classes.conApi.Personajes
import com.example.estudio3.classes.conApi.Planetas
import com.example.estudio3.classes.productosYcategorias.ProductMofrl

class ProductViewModel {

    fun mostrarProducto1(): List<ProductMofrl>{
        var listaProductos =mutableListOf<ProductMofrl>()
        listaProductos.add(
            ProductMofrl(
                uid = "nada",
                Nombre = "Producto 1",
                imagen = R.drawable.estrellas,
                gusto = true
            )
        )
        return listaProductos
    }

    fun mostrarProducto2(): List<ProductMofrl>{
        var listaProductos =mutableListOf<ProductMofrl>()


        listaProductos.add(
            ProductMofrl(
                uid = "nada",

                Nombre = "Producto 2",
                imagen = R.drawable.muro,
                gusto = true
            )
        )



        return listaProductos
    }


    fun mostrarProducto3(): List<ProductMofrl>{
        var listaProductos =mutableListOf<ProductMofrl>()


        listaProductos.add(
            ProductMofrl(
                uid = "nada",

                Nombre = "Producto 3",
                imagen = R.drawable.golshi,
                gusto = true
            )
        )

        return listaProductos
    }

       fun emptyList(): List<ProductMofrl>{
            var listaProductos =mutableListOf<ProductMofrl>()


            listaProductos.add(
                ProductMofrl(
                    uid = "nada",

                    Nombre = "NADA",
                    imagen = R.drawable.nada,
                    gusto = true
                )
            )

        return listaProductos
    }


    // Funciones auxiliares para convertir los datos de la API a tu modelo de tarjeta
// Actualiza estas funciones en tu ProductViewModel
// --- PERSONAJES ---
    private fun transformarAPer(lista: List<Personajes>) = lista.map {
        ProductMofrl(
            uid = it.uid,
            Nombre = it.name,
            imagen = obtenerImagen(it.uid, 4),
            url = it.url,
            genero = it.gender,    // <--- Nuevo
            colorOjos = it.eye_color // <--- Nuevo
        )
    }

    // --- PLANETAS ---
    private fun transformarAPla(lista: List<Planetas>) = lista.map {
        ProductMofrl(
            uid = it.uid,
            Nombre = it.name,
            imagen = obtenerImagen(it.uid, 5),
            url = it.url,
            clima = it.climate,   // <--- Nuevo
            terreno = it.terrain  // <--- Nuevo
        )
    }

    // --- NAVES ---
    private fun transformarANav(lista: List<Naves>) = lista.map {
        ProductMofrl(
            uid = it.uid,
            Nombre = it.name,
            imagen = obtenerImagen(it.uid, 6),
            url = it.url,
            modelo = it.model,          // <--- Nuevo
            costo = it.cost_in_credits // <--- Nuevo
        )
    }
    // Dentro de ProductViewModel
    fun obtenerImagen(uid: String, categoria: Int): Int {
        return when (categoria) {
            4 -> { // PERSONAJES
                when (uid) {
                    "1" -> R.drawable.luke
                    else -> R.drawable.personajes // Imagen por defecto
                }
            }
            5 -> { // PLANETAS
                when (uid) {
                    "1" -> R.drawable.tatoine
                    else -> R.drawable.planetas
                }
            }
            6 -> { // NAVES
                when (uid) {
                    "9" -> R.drawable.deathstar
                    else -> R.drawable.naves
                }
            }
            else -> R.drawable.nada
        }
    }


//    fun seleccionador(IdCategoria: Int):List<ProductMofrl>{
//        return when (IdCategoria){
//            1 ->mostrarProducto1()
//            2 -> mostrarProducto2()
//            3 -> mostrarProducto3()
//            else -> emptyList()
//        }
//    }

    // En ProductViewModel.kt
    fun buscarEnListas(id: Int, cat: Int, swVM: StarwarsViewModel): ProductMofrl? {
        // Obtenemos la lista que corresponde según la categoría
        val listaBase = when (cat) {
            4 -> transformarAPer(swVM.listarPersonajes)
            5 -> transformarAPla(swVM.listarPlanetas)
            6 -> transformarANav(swVM.listarNaves)
            else -> emptyList()
        }
        // Buscamos el que coincida con el UID
        return listaBase.find { it.uid == id.toString() }
    }

    fun seleccionador(
        idCategoria: Int,
        swViewModel: StarwarsViewModel // Le pasamos el ViewModel para sacar los datos
    ): List<ProductMofrl> {
        return when (idCategoria) {
            1 -> mostrarProducto1()
            2 -> mostrarProducto2()
            3 -> mostrarProducto3()
            // IDENTIFICACIÓN POR ID:
            4 -> transformarAPer(swViewModel.listarPersonajes)
            5 -> transformarAPla(swViewModel.listarPlanetas)
            6 -> transformarANav(swViewModel.listarNaves)
            // Para las naves puedes crear otra lista en el ViewModel similar a las otras
            else -> emptyList()
        }
    }
}