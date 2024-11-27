package com.mbougar.pmdm_pruebapracticaenclase.navigation

sealed class AppScreen(val route: String) {
    object FirstScreen: AppScreen("FirstScreen")
}