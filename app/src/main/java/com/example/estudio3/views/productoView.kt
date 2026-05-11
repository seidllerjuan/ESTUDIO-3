package com.example.estudio3.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.estudio3.classes.productosYcategorias.ProductViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import coil3.compose.AsyncImage
import com.example.estudio3.API.StarwarsViewModel
import com.example.estudio3.R

@Composable
fun ProducTview(
    navegar: NavHostController,
    Seleccionado: MutableState<Int>,
    swViewModel: StarwarsViewModel,
    UidSeleccionada: MutableState<Int>
) {
    val busqueda = androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("") }

    androidx.compose.runtime.LaunchedEffect(Seleccionado.value) {
        when (Seleccionado.value) {
            4 -> swViewModel.fetchPersonajes()
            5 -> swViewModel.fetchPlanetas()
            6 -> swViewModel.fetchNaves()
        }
    }

    val datos = ProductViewModel().seleccionador(Seleccionado.value, swViewModel)
    val filtrados = datos.filter { it.Nombre.uppercase().contains(busqueda.value.uppercase()) }

    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {

        Button(onClick = { navegar.navigate("Category") }) {
            Text("Regresar")
        }

        Text("Filtrar resultados:", modifier = Modifier.padding(top = 10.dp))
        androidx.compose.material3.TextField(
            value = busqueda.value,
            onValueChange = { busqueda.value = it },
            placeholder = { Text("Escribe un nombre...") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

        // --- LÓGICA DEL LOADER ---
        // Si la lista original está vacía y no hemos escrito nada en el buscador,
        // significa que la API sigue cargando.
        if (datos.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                androidx.compose.material3.CircularProgressIndicator() // El círculo de carga
                Spacer(modifier = Modifier.height(10.dp))
                Text("Cargando datos de la API...")
            }
        } else {
            // Si ya hay datos, mostramos la lista normal
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(filtrados) { p ->
                    Card(
                        modifier = Modifier.fillMaxWidth().clickable {
                            UidSeleccionada.value = p.uid.toIntOrNull() ?: 0
                            navegar.navigate("info")
                        }
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = p.imagen),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth().height(180.dp),
                                contentScale = ContentScale.Crop
                            )

                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(text = p.Nombre, style = MaterialTheme.typography.titleLarge)
                                Text(
                                    text = if (p.gusto) "Es favorito" else "No es favorito",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}