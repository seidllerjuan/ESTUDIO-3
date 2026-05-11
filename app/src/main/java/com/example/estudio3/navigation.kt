package com.example.estudio3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.estudio3.API.StarwarsViewModel
import com.example.estudio3.classes.productosYcategorias.CategoryViewModel
import com.example.estudio3.views.CategoryView
import com.example.estudio3.views.HomeView
import com.example.estudio3.views.Information
import com.example.estudio3.views.ProducTview

@Composable
fun NavManager(){
    val navController = rememberNavController()

    val Categorias = remember{ CategoryViewModel().GenerateCategory()}
    val ElementoSeleccionado = remember { mutableStateOf(0) }

    //INSTNACIAMOS LA CLASE
    val swViewModel: StarwarsViewModel = viewModel()

    val verInformacionDe = remember { mutableStateOf(0) }


    NavHost(navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navController)
        }
        composable("Category"){
            CategoryView(navController,Categorias, ElementoSeleccionado)
        }

        composable("productos"){
            ProducTview(navController,ElementoSeleccionado,swViewModel,verInformacionDe)
        }

        composable("info") {
            // Le pasamos el swViewModel para buscar los datos y ElementoSeleccionado para saber la categoría
            Information(navController, verInformacionDe, swViewModel, ElementoSeleccionado)
        }

    }
}