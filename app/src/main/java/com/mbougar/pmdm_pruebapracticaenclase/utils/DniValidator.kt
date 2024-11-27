package com.mbougar.pmdm_pruebapracticaenclase.utils

object DniValidator {

    fun esDniValido(dni: String): Boolean {

        // Establece un patron regex que debe seguir un dni
        val dniRegex = Regex("^\\d{8}[A-Z]$")
        if (!dniRegex.matches(dni)) {
            return false
        }

        val numero = dni.substring(0, 8).toInt()
        val letra = dni.last()

        //Establece el orden de asignacion de letras a un dni dependendo de su numero
        val letras = "TRWAGMYFPDXBNJZSQVHLCKE"
        val letraCorrecta = letras[numero % 23]

        return letra == letraCorrecta
    }
}