package com.example.estudio3.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.estudio3.R
import com.example.estudio3.classes.productosYcategorias.CategoryViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.unit.dp
import com.example.estudio3.classes.productosYcategorias.categoriasModel


@Composable
fun HomeView(navegar: NavHostController){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.estrellas),
            contentDescription = "Imagen de ejemplos",
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            contentScale = ContentScale.FillBounds
        )
        OutlinedButton(onClick = {
            navegar.navigate("Category")
        }, modifier = Modifier.align(Alignment.BottomCenter).
        padding(bottom = 40.dp)) {
            Text("Iniciar")
        }
    }
}