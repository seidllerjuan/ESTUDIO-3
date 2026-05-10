package com.example.estudio3.views

import androidx.compose.foundation.Image
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
import com.example.estudio3.R


@Composable
fun ProducTview(navegar: NavHostController, Seleccionado: MutableState<Int>){

    var ELECCION = ProductViewModel().seleccionador(Seleccionado.value)
    Column(modifier = Modifier.fillMaxSize()) {
        // Botón Volver arriba (Fijo)
        Button(
            onClick = { navegar.navigate("Category") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Volver a Categorías")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(ELECCION) { producto ->
                // Tarjeta de Producto Estilizada
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = producto.imagen),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth().height(200.dp),
                            contentScale = ContentScale.Crop // Mejor que FillBounds
                        )
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = producto.Nombre, style = MaterialTheme.typography.headlineSmall)
                            Text(
                                text = if (producto.gusto) "❤️ Favorito" else "🤍 Sin marcar",
                                color = if (producto.gusto) Color.Red else Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}