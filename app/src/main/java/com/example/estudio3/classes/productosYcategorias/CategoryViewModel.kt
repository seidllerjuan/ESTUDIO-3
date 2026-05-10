package com.example.estudio3.classes.productosYcategorias

import com.example.estudio3.R

class CategoryViewModel {
    fun GenerateCategory():List<categoriasModel>{
        val categoryList = mutableListOf<categoriasModel>()
        categoryList.add(
            categoriasModel(
                id = 1,
                nombre = "Categoria 1",
                imaegn = R.drawable.estrellas
            )
        )
        categoryList.add(
            categoriasModel(
                id = 2,
                nombre = "Categoria 2",
                imaegn = R.drawable.muro
            )
        )

        categoryList.add(
            categoriasModel(
                id = 3,
                nombre = "Categoria 3",
                imaegn = R.drawable.golshi
            )
        )


        return categoryList
    }
}