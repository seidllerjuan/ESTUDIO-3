package com.example.estudio3.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estudio3.API.StarwarsViewModel
import com.example.estudio3.classes.productosYcategorias.ProductViewModel

@Composable
fun Information(
    navegar: NavHostController,
    idSeleccionado: MutableState<Int>,
    swViewModel: StarwarsViewModel,
    categoriaSeleccionada: MutableState<Int>
) {
    // Buscamos el objeto con la función que ya tenemos
    val objeto = ProductViewModel().buscarEnListas(
        idSeleccionado.value,
        categoriaSeleccionada.value,
        swViewModel
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp) // Un padding más estándar
    ) {
        // Título simple
        Text(text = "Detalles del elemento", color = Color.Gray)

        Spacer(modifier = Modifier.height(10.dp))

        objeto?.let { item ->
            // Nombre en texto plano pero grande (estilo manual)
            Text(
                text = item.Nombre,
                style = MaterialTheme.typography.titleLarge, // Menos exagerado que headline
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(15.dp))

            // La foto del personaje/planeta
            Image(
                painter = painterResource(id = item.imagen),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Un poco más pequeña
                contentScale = ContentScale.Fit // Fit hace que se vea la foto completa, no recortada
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Información de la URL sin tanto adorno
            Text(text = "Link de la API:")
            Text(
                text = item.url,
                color = Color(0xFF0000EE) // Un azul de link de toda la vida
            )

            // Si quieres que se vea más "informativo escolar", puedes poner el UID
            Text(text = "ID del objeto: ${item.uid}", modifier = Modifier.padding(top = 10.dp))

        } ?: Text("Buscando en la galaxia...") // Un mensaje más relajado

        Spacer(modifier = Modifier.weight(1f))

        // Botón normal
        Button(
            onClick = { navegar.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar a la lista")
        }
    }
}