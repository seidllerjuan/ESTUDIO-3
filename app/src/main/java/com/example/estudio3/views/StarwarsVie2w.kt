package com.example.estudio3.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.example.estudio3.API.StarwarsViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text

@Composable
fun PantallaStarWars(viewModel: StarwarsViewModel){
    val personajes = viewModel.listarPersonajes

    Column() {
        Button(onClick = {
            viewModel.fetchPersonajes()

        }) {
            Text("Caregar Personajes")
        }
        LazyColumn() {
            items(personajes){ personaje ->
                Text(personaje.name)

            }
        }

    }
}