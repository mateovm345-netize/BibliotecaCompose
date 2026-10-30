package com.sena.bibliotecacompose.ui.section

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun EncabezadoCatalogo() {
    Column {
        Text(
            text = "Catálogo de libros",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF174A7E)
        )

        Text(
            text = "Explora los libros de nuestra biblioteca.",
            color = Color.Gray
        )
    }
}