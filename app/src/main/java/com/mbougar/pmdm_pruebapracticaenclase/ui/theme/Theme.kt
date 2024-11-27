package com.mbougar.pmdm_pruebapracticaenclase.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme

private val DarkColorPalette = darkColorScheme(
    primary = ColorPrimaryDark,
    onPrimary = ColorOnPrimaryDark,
    primaryContainer = ColorPrimaryContainerDark,
    onPrimaryContainer = ColorOnPrimaryContainerDark,
    background = ColorBackgroundDark,
    onBackground = ColorOnBackgroundDark
)

private val LightColorPalette = lightColorScheme(
    primary = ColorPrimaryLight,
    onPrimary = ColorOnPrimaryLight,
    primaryContainer = ColorPrimaryContainerLight,
    onPrimaryContainer = ColorOnPrimaryContainerLight,
    background = ColorBackgroundLight,
    onBackground = ColorOnBackgroundLight
)

@Composable
fun MyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = OutfitTypography,
        content = content
    )
}