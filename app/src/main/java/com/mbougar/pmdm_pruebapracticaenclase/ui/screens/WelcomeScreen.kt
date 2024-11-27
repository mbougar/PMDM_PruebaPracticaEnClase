package com.mbougar.pmdm_pruebapracticaenclase.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mbougar.pmdm_pruebapracticaenclase.model.User

@Composable
fun WelcomeScreen(user: User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bienvenido ${user.nombre}",
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = "Nombre: ${user.nombre}\nPrimer Apellido: ${user.apellido1}\nSegundo Apellido: ${user.apellido2.ifEmpty { "n/a" }}\nDNI: ${user.dni}\nEdad: ${user.edad}",
            onValueChange = {},
            label = { Text("Información del usuario") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
    }
}