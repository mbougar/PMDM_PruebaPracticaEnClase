package com.mbougar.pmdm_pruebapracticaenclase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.*
import androidx.navigation.toRoute
import com.mbougar.pmdm_pruebapracticaenclase.model.User
import com.mbougar.pmdm_pruebapracticaenclase.ui.screens.MainScreen
import com.mbougar.pmdm_pruebapracticaenclase.ui.screens.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    //Instanciamos el navHost y establecemos la screen de inicio como First Screen
    NavHost(navController = navController, startDestination = AppScreen.FirstScreen.route) {
        composable(AppScreen.FirstScreen.route) {
            MainScreen(navController)
        }
        //Creamos una navegacion con ruta a un usuario creado
        composable<User> {
            val user: User = it.toRoute()
            WelcomeScreen(user)
        }
    }
}