package com.mbougar.pmdm_pruebapracticaenclase.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mbougar.pmdm_pruebapracticaenclase.ui.theme.ColorOnPrimaryContainerLight
import com.mbougar.pmdm_pruebapracticaenclase.ui.theme.ColorPrimaryContainerLight

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