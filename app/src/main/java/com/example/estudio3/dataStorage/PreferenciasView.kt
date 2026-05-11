package com.example.estudio3.dataStorage

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun PreferenciasView(){
    // Paso 8: Instanciamos la clase y la corrutina[cite: 35, 36].
    val context = LocalContext.current
    val preferences = remember { preferenciasClase(context) }
    val coroutineScope = rememberCoroutineScope()

    // Paso Final: Recopilar la información del Flow y transformarla a State[cite: 40, 41].

    val savedName = preferences.name.collectAsState(initial = "")
    val savedAge = preferences.age.collectAsState(initial = 0)

    // --- NUEVOS ESTADOS OBSERVADOS ---
    val savedEmail = preferences.email.collectAsState(initial = "")
    val savedDarkMode = preferences.isDarkMode.collectAsState(initial = false)

    // Variables locales para los TextField
    var nameInput by remember { mutableStateOf("") }
    var ageInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var darkModeInput by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        // Paso 7: Interfaz con TextFields[cite: 31, 32].
        TextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = ageInput,
            onValueChange = { ageInput = it },
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // --- NUEVO TEXTFIELD PARA CORREO ---
        TextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // --- NUEVO SWITCH PARA MODO OSCURO ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Modo Oscuro: ")
            Switch(
                checked = darkModeInput,
                onCheckedChange = { darkModeInput = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Paso 8: Botón para guardar datos usando la corrutina[cite: 37, 38].
        Button(
            onClick = {
                coroutineScope.launch {
                    // Llamamos a la función actualizada con todos los parámetros
                    preferences.savePersonData(
                        nameInput,
                        ageInput.toIntOrNull() ?: 0,
                        emailInput,
                        darkModeInput
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Configuración Completa")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Mostrar la información guardada usando .value[cite: 42, 43].
        Text("DATOS PERSISTENTES:", modifier = Modifier.padding(bottom = 8.dp))
        Text("Nombre: ${savedName.value}")
        Text("Edad: ${savedAge.value}")
        Text("Email: ${savedEmail.value}")
        Text("Oscuro: ${if (savedDarkMode.value) "Sí" else "No"}")

        Button(
            onClick = {
                coroutineScope.launch {
                    preferences.clearSesion()
                }
            },
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
        ) {
            Text("Limpiar Todo")
        }
    }
}