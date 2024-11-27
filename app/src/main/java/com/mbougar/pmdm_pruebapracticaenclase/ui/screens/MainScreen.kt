package com.mbougar.pmdm_pruebapracticaenclase.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mbougar.pmdm_pruebapracticaenclase.model.User
import com.mbougar.pmdm_pruebapracticaenclase.ui.components.DialogoError
import com.mbougar.pmdm_pruebapracticaenclase.ui.components.InputNumero
import com.mbougar.pmdm_pruebapracticaenclase.ui.components.InputTexto
import com.mbougar.pmdm_pruebapracticaenclase.ui.components.SendButton
import com.mbougar.pmdm_pruebapracticaenclase.utils.DniValidator

@Composable
fun MainScreen(navController: NavController) {
    val (nombre, setNombre) = rememberSaveable { mutableStateOf("") }
    val (apellido1, setapellido1) = rememberSaveable { mutableStateOf("") }
    val (apellido2, setapellido2) = rememberSaveable { mutableStateOf("") }
    val (dni, setDni) = rememberSaveable { mutableStateOf("") }
    val (edad, setEdad) = rememberSaveable { mutableStateOf("") }
    var mostrarError by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center
    ) {
        if (mostrarError) {
            DialogoError(onDismiss = { mostrarError = false })
        }
        //Lo metemos en una lazy column para que al girar el movil por
        // ejemplo se pueda seguir haciendo scroll y usa la app
        LazyColumn {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,

                ) {
                    Text(text = "Ingrese sus datos:", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
            item {
                InputTexto(nombre, setNombre, "Nombre*")
                Spacer(modifier = Modifier.size(4.dp))
            }
            item {
                InputTexto(apellido1, setapellido1, "Primer Apellido*")
                Spacer(modifier = Modifier.size(4.dp))
            }
            item {
                InputTexto(apellido2, setapellido2, "Segundo Apellido")
                Spacer(modifier = Modifier.size(4.dp))
            }
            item {
                InputTexto(dni, setDni, "DNI*")
                Spacer(modifier = Modifier.size(4.dp))
            }
            item {
                InputNumero(edad, setEdad, "Edad*")
                Spacer(modifier = Modifier.size(16.dp))
            }
            item {
                if (DniValidator.esDniValido(dni) && apellido1.isNotBlank() && nombre.isNotBlank() && edad.isNotBlank()) {
                    SendButton {
                        try {
                            //DniValidator nos lo ha dado Diego en la clase de Acceso a Datos
                            navController.navigate(
                                // Le decimos al navigator que debe navegar a una ruta dada por el User,
                                // podemos hacer esto gracias a serializable
                                route = User(
                                    nombre,
                                    apellido1,
                                    apellido2,
                                    dni,
                                    //No hace falta controllar con excepcion porque ya lo
                                    // controlamos en el input del textfield
                                    edad.toInt()
                                )
                            )
                        } catch (_: Exception) {
                            mostrarError = true
                        }
                    }
                }
            }
        }
    }
}