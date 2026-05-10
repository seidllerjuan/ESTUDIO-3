package com.example.estudio3.classes.productosYcategorias

import com.example.estudio3.R
import com.example.estudio3.classes.productosYcategorias.ProductMofrl

class ProductViewModel {

    fun mostrarProducto1(): List<ProductMofrl>{
        var listaProductos =mutableListOf<ProductMofrl>()
        listaProductos.add(
            ProductMofrl(
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
                    Nombre = "NADA",
                    imagen = R.drawable.nada,
                    gusto = true
                )
            )

        return listaProductos
    }





    fun seleccionador(IdCategoria: Int):List<ProductMofrl>{
        return when (IdCategoria){
            1 ->mostrarProducto1()
            2 -> mostrarProducto2()
            3 -> mostrarProducto3()
            else -> emptyList()
        }
    }
}