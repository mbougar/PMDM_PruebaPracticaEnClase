package com.mbougar.pmdm_pruebapracticaenclase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.mbougar.pmdm_pruebapracticaenclase.navigation.AppNavigation
import com.mbougar.pmdm_pruebapracticaenclase.ui.screens.MainScreen
import com.mbougar.pmdm_pruebapracticaenclase.ui.theme.MyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme()
            {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}