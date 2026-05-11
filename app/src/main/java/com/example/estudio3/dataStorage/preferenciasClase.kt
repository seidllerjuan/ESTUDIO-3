package com.example.estudio3.dataStorage

import android.R
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Paso 3: Creamos la instancia de DataStore (Singleton)
// El nombre "settings" es el nombre del archivo físico en el dispositivo[cite: 14].
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name= "settings")
class preferenciasClase(private val context: Context) {

    // Paso 4: Establecemos las llaves y sus tipos de datos dentro del companion object[cite: 17, 18].
    companion object {
        val AGE = intPreferencesKey("edad")
        val NAME = stringPreferencesKey("nombre")

        // NUEVAS LLAVES CONFIGURACION GUARDADA
        val EMAIL = stringPreferencesKey("correo")
        val DARK_MODE = booleanPreferencesKey("modo_oscuro")
    }

    // Paso 5: Lectura de valores mediante Flow.
    // Usamos .map para extraer el valor de la llave y un valor por defecto si es nulo[cite: 22, 23, 24, 25].

    val name: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[NAME] ?: ""
    }

    val age: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[AGE]?: 0
    }


    // AGREGAMOS L,OS NUEVOS CMAPOS DE LECTURA
    // Lectura del correo
    val email: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[EMAIL] ?: "no-email@ejemplo.com" // Valor por defecto [cite: 23, 25]
    }

    // Lectura del modo oscuro
    val isDarkMode: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[DARK_MODE] ?: false
    }

    // Paso 6: Escritura de valores.
    // Usamos "suspend" porque es una operación de escritura en disco[cite: 28, 29, 30].

    suspend fun savePersonData (personName: String,personaAge: Int, personaEmail: String, darkmode: Boolean){
        context.dataStore.edit { configuraciones ->
            configuraciones[AGE] = personaAge
            configuraciones[NAME] = personName
            // GUARDAR NUEVOS DATOS
            configuraciones[EMAIL] = personaEmail
            configuraciones[DARK_MODE] = darkmode

        }
    }

    suspend fun  clearSesion(){
        context.dataStore.edit { preferences ->
            preferences.remove(AGE)
            preferences.remove(NAME)
            preferences.remove(EMAIL) // Limpia también el correo
            preferences.remove(DARK_MODE) // Limpia el modo oscuro

        }
    }


}