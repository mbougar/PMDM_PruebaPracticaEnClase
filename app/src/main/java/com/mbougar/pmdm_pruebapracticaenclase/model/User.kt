package com.mbougar.pmdm_pruebapracticaenclase.model

import kotlinx.serialization.Serializable

//Serializable nos permite convertir la clase en un json que podamos usar en el navigator
@Serializable
data class User(
    val nombre: String,
    val apellido1: String,
    val apellido2: String,
    val dni: String,
    val edad: Int
)