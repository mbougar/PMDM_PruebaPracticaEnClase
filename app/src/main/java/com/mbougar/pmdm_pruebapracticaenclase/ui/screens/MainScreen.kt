package com.mbougar.pmdm_pruebapracticaenclase.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mbougar.pmdm_pruebapracticaenclase.model.User
import com.mbougar.pmdm_pruebapracticaenclase.ui.theme.ColorOnPrimaryContainerLight
import com.mbougar.pmdm_pruebapracticaenclase.ui.theme.ColorPrimaryContainerLight
import com.mbougar.pmdm_pruebapracticaenclase.utils.DniValidator

@Composable
fun MainScreen(navController: NavController) {
    val (nombre, setNombre) = rememberSaveable { mutableStateOf("") }
    val (apellido1, setapellido1) = rememberSaveable { mutableStateOf("") }
    val (apellido2, setapellido2) = rememberSaveable { mutableStateOf("") }
    val (dni, setDni) = rememberSaveable { mutableStateOf("") }
    val (edad, setEdad) = rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center
    ) {
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

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InputTexto(
    newString: String,
    setNewString: (String) -> Unit,
    label: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            singleLine = true,
            value = newString,
            onValueChange = setNewString,
            label = { Text(label)},
            modifier = Modifier,
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
    }
}

@Composable
fun InputNumero(
    newNumber: String,
    setNewNumber: (String) -> Unit,
    label: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            singleLine = true,
            value = newNumber,
            onValueChange = { input ->
                if (input.all { it.isDigit() }) {
                    setNewNumber(input)
                }
            },
            label = { Text(label) },
            modifier = Modifier,
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
    }
}

@Composable
fun SendButton(
    onNavigateToChat: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        TextButton(
            onClick = onNavigateToChat,
            colors =
                ButtonDefaults.textButtonColors().copy(
                    containerColor = ColorPrimaryContainerLight,
                    contentColor = ColorOnPrimaryContainerLight
                )
        ) {
            Text("Ingresar Datos")
        }
    }
}

@Composable
fun AvisoCampoObligatorio() {
    Text(text = "Campo Obligatorio")
}