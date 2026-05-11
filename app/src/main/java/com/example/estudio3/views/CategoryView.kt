package com.example.estudio3.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estudio3.classes.productosYcategorias.categoriasModel
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import com.example.estudio3.R

@Composable
//Instanciamos la data class no la clase
fun CategoryView(navegar: NavHostController,
                 Mostrarcategorias: List<categoriasModel>,
                 ElementoSeleccionado: MutableState<Int>){

    Column(Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.SpaceEvenly) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp) // Altura estándar de una TopBar
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically, // Alinea todo al centro vertical
            horizontalArrangement = Arrangement.SpaceBetween // Separa los elementos proporcionalmente
        ) {
            // 1. Imagen/Icono de perfil
            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Perfil",
                modifier = Modifier
                    .size(40.dp) // Tamaño fijo para que no se deforme
                    .clip(CircleShape).clickable {
                        navegar.navigate("data")

                    }, // Opcional: hace la imagen circular
                contentScale = ContentScale.Crop
            )

            // 2. Texto central (usamos weight para que empuje al botón a la derecha)
            Text(
                text = "Elije una Categoria",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f), // Toma el espacio disponible
                style = MaterialTheme.typography.bodyLarge
            )

            // 3. Botón de cerrar
            Button(
                onClick = { navegar.navigate("Home") },
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Text("Cerrar")
            }
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(Mostrarcategorias) { categoria ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clickable {
                            ElementoSeleccionado.value = categoria.id
                            navegar.navigate("productos")
                        },
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    // Usamos un solo Box para que TODO se encime (Fondo -> Degradado -> Textos -> Icono)
                    Box(modifier = Modifier.fillMaxSize()) {

                        // 1. Imagen de fondo (Capas de abajo hacia arriba)
                        Image(
                            painter = painterResource(id = categoria.imaegn),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        // 2. Overlay Degradado
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Black.copy(alpha = 0.6f),
                                            Color.Transparent
                                        ),
                                        endY = 400f
                                    )
                                )
                        )

                        // 3. Textos (Arriba a la izquierda)
                        Column(
                            modifier = Modifier
                                .align(Alignment.TopStart) // Alineado a la izquierda
                                .padding(20.dp)
                        ) {
                            Text(
                                text = categoria.nombre,
                                color = Color.White,
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(
                                text = "EXPLORAR",
                                color = Color.White.copy(alpha = 0.7f),
                                style = MaterialTheme.typography.labelSmall
                            )
                        }

                        // 4. ICONO DE CLASE (Arriba a la derecha)
                        // Al estar dentro del mismo Box, flotará sobre la imagen
                        Image(
                            painter = painterResource(id = R.drawable.perfil),
                            contentDescription = "class",
                            modifier = Modifier
                                .padding(16.dp) // Margen desde la esquina
                                .size(45.dp)
                                .clip(CircleShape)
                                .align(Alignment.TopEnd), // <--- ESTO LO ENVÍA A LA ESQUINA DERECHA
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
// Cambia el LazyColumn por este LazyVerticalGrid
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2), // <--- ¡Esto crea las dos columnas!
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f),
//            contentPadding = PaddingValues(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(Mostrarcategorias) { categoria ->
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(1f) // <--- Hace que las cards sean cuadraditas y perfectas
//                        .clickable {
//                            ElementoSeleccionado.value = categoria.id
//                            navegar.navigate("productos")
//                        },
//                    shape = RoundedCornerShape(16.dp),
//                    elevation = CardDefaults.cardElevation(4.dp)
//                ) {
//                    Box(modifier = Modifier.fillMaxSize()) {
//                        Image(
//                            painter = painterResource(id = categoria.imaegn),
//                            contentDescription = null,
//                            modifier = Modifier.fillMaxSize(),
//                            contentScale = ContentScale.Crop
//                        )
//
//                        // Degradado en la parte de abajo para que el nombre se vea pro
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .background(
//                                    brush = androidx.compose.ui.graphics.Brush.verticalGradient(
//                                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f)),
//                                        startY = 150f
//                                    )
//                                )
//                        )
//
//                        Text(
//                            text = categoria.nombre,
//                            color = Color.White,
//                            modifier = Modifier
//                                .align(Alignment.BottomCenter)
//                                .padding(bottom = 12.dp),
//                            style = MaterialTheme.typography.titleMedium,
//                            fontWeight = FontWeight.Bold
//                        )
//                    }
//                }
//            }
//        }
        }
    }
}