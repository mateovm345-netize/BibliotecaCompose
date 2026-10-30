package com.sena.bibliotecacompose.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun EstadoDisponibilidad(disponible: Boolean) {
    if (disponible) {
        Text(
            text = "Disponible",
            color = Color(0xFF18753A)
        )
    } else {
        Text(
            text = "Prestado",
            color = Color.Red
        )
    }
}
