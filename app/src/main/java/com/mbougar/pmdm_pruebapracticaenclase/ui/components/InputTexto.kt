package com.mbougar.pmdm_pruebapracticaenclase.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

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
            label = { Text(label) },
            modifier = Modifier,
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
            )
        )
    }
}